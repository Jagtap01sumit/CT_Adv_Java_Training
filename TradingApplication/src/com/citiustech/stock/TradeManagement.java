package com.citiustech.stock;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.citiustech.db.ConnectionSetting;
import com.citiustech.db.DBConnection;
import com.citiustech.db.StockDAO;
import com.citiustech.exceptions.NoTradeHistoryException;
import com.citiustech.exceptions.StocksUnavailableException;
import com.citiustech.exceptions.UserAlreadyExistException;

public class TradeManagement implements TradeOperations {
	static DBConnection db = new DBConnection();

	private TradeManagement() {
	}

	StockDAO stocks = new StockDAO();
	static List<Trade> tradeList = new ArrayList<>();
	private Connection conn;

	public static TradeManagement TradeM() {
		TradeManagement trd = new TradeManagement();
		return trd;
	}

	public static void trade(BaseEntity user, Stock stock, int quantity, String tradeType) {
		User casteUser = (User) user;
		int userId = fetchCurrentUserId(casteUser.email());
		System.out.println("userId3" + userId);
		Trade trd = new Trade(userId, stock, quantity, tradeType);
		TradeManagement tm = new TradeManagement();
		if (tradeType.equals("BUY")) {
			try {
				tm.buyStock(user, stock, quantity);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (tradeType.equals("SELL")) {
			try {
				tm.sellStock(user, stock, quantity);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		tradeList.add(trd);
	}

	@Override
	public void buyStock(BaseEntity user, Stock stock, int quantity) {
		stocks.updateStockQuantity(stock, quantity, true);
		User userId = (User) user;
		int id = fetchCurrentUserId(userId.email());
		saveTradeToDB(new Trade(id, stock, quantity, "BUY"));
	}

	@Override
	public void sellStock(BaseEntity user, Stock stock, int quantity) {
		User userId = (User) user;
		if (!isStockInPortfolio(user, stock)) {
			throw new StocksUnavailableException("You don't have " + stock.symbol() + " stocks to sell");
		}
		int id = fetchCurrentUserId(userId.email());
		stocks.updateStockQuantity(stock, quantity, false);
		saveTradeToDB(new Trade(id, stock, quantity, "SELL"));
	}

	@Override
	public void history(BaseEntity user) throws NoTradeHistoryException {
		User castedUser = (User) user;

		int userId = fetchCurrentUserId(castedUser.email());
		System.out.println(userId);
		List<Trade> tradeList = new ArrayList<>();
		try (Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM trade_history where user_id=?")) {
			pstmt.setInt(1, userId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String stockSymbol = rs.getString("stock_symbol");
					int quantity = rs.getInt("quantity");
					String tradeType = rs.getString("trade_type");
					Stock stock = getStockBySymbol(stockSymbol);
					Trade trade = new Trade(userId, stock, quantity, tradeType);
					System.out.println(trade.tradeType());
					tradeList.add(trade);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error retrieving trade history", e);
		}
		
			if (tradeList.isEmpty()) {
			    throw new NoTradeHistoryException("No trade history found for user " + userId);
			}
			for (Trade trade : tradeList) {
				System.out.println(trade.toString());
			}
		
	}

	@Override
	public Map<String, Integer> portfolioValue(BaseEntity user) {
		User email = (User) user;
		int userId = fetchCurrentUserId(email.email());
		Map<String, Integer> portfolio = new HashMap<>();
		try (Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"SELECT stock_symbol, quantity, trade_type FROM trade_history WHERE user_id = ?")) {
			pstmt.setInt(1, userId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String stockName = rs.getString("stock_symbol");
					int stockQuantity = rs.getInt("quantity");
					String tradeType = rs.getString("trade_type");

					if (portfolio.containsKey(stockName)) {
						if ("BUY".equals(tradeType)) {
							portfolio.put(stockName, portfolio.get(stockName) + stockQuantity);
						} else if ("SELL".equals(tradeType)) {
							int currentQuantity = portfolio.get(stockName);
							if (currentQuantity >= stockQuantity) {
								portfolio.put(stockName, currentQuantity - stockQuantity);
							} else {
								throw new StocksUnavailableException(
										"You don't have enough " + stockName + " stocks to sell");
							}
						}
					} else {
						portfolio.put(stockName, stockQuantity);
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Error fetching portfolio: " + e.getMessage());
		}
		return portfolio;
	}

	// utility methods
	public Stock getStockBySymbol(String stock_symbol) {
		try (Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Stocks where symbol = ?")) {
			pstmt.setString(1, stock_symbol);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Stock stock = new Stock(rs.getString(2), rs.getString(4), rs.getDouble(3), rs.getInt(5));
					return stock;
				}
				return null;
			} catch (SQLException e) {
				throw new RuntimeException("Error retrieving stock", e);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error connecting to database", e);
		}
	}

	public boolean isStockInPortfolio(BaseEntity user, Stock stock) {

		Map<String, Integer> map = TradeManagement.fetchPortfolio(user);
		if (map.containsKey(stock.symbol())) {
			return true;
		}
		return false;
	}

	public static void viewHistory(BaseEntity user) throws NoTradeHistoryException {
		TradeManagement tr = new TradeManagement();
		tr.history(user);
	
	}

	public static int fetchCurrentUserId(String email) {
		int userId = -1;
		try (Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM users WHERE email = ?")) {
			pstmt.setString(1, email);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					userId = rs.getInt("id");
				} else {
					throw new RuntimeException("User not found with email: " + email);
				}
			}
		} catch (SQLException e) {
			System.err.println("Error fetching user ID: " + e.getMessage());
		}
		return userId;
	}

	public static Map<String, Integer> fetchPortfolio(BaseEntity user) {
		User castedUser = (User) user;
		TradeManagement td = new TradeManagement();
		castedUser.savePortfolio(td.portfolioValue(user));
		return td.portfolioValue(user);
	}

	// Stored procedure
	public void createGetNextIdProcedure() {
		try (Statement statement = db.getConnection().createStatement()) {
			System.out.println("Hello");
			statement.executeUpdate("DROP PROCEDURE IF EXISTS sp_get_next_id_trade_history");
			statement.executeUpdate("CREATE PROCEDURE sp_get_next_id_trade_history(OUT next_id INT) " + "BEGIN "
					+ "    SET next_id = (SELECT current_count + 1 FROM counter WHERE table_name='trade'); "
					+ "    UPDATE counter SET current_count = next_id WHERE table_name='trade'; " + "END");
			System.out.println("Procedure created successfully!");
		} catch (SQLException e) {
			System.out.println("Error creating procedure: " + e.getMessage());
		}
	}

	public void saveTradeToDB(Trade trade) {
		createGetNextIdProcedure();
		try (CallableStatement statement = db.getConnection().prepareCall(" CALL sp_get_next_id_trade_history(?)")) {
			statement.registerOutParameter(1, Types.INTEGER);
			statement.execute();
			int nextId = statement.getInt(1);

			try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(
					"INSERT INTO trade_history (id, user_id, stock_symbol, quantity, trade_type, time_stamp) VALUES (?, ?, ?, ?, ?, NOW())")) {
				preparedStatement.setInt(1, nextId);
				System.out.println(trade.userId() + "user id");
				preparedStatement.setInt(2, trade.userId());
				preparedStatement.setString(3, trade.stock.symbol());
				preparedStatement.setInt(4, trade.quantity());
				preparedStatement.setString(5, trade.tradeType());
				preparedStatement.executeUpdate();
			}
			System.out.println("Trade saved successfully! Trade ID: " + nextId);
		} catch (SQLException e) {
			System.out.println("Error saving trade: " + e.getMessage());
		}
	}

}