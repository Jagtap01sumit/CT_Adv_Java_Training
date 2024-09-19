package com.citiustech.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.citiustech.stock.Stock;
import com.citiustech.stock.TradeManagement;

public class StockDB{
static DBConnection db=new DBConnection();

    
    public List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList<>();

        try (Connection conn =db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Stocks")) {

            while (rs.next()) {
                Stock stock = new Stock(
                        rs.getString(2),
                        rs.getString(4),
                        rs.getDouble(3),
                        
                        rs.getInt(5)
                );
               
               
                stocks.add(stock);
            }
        } catch (SQLException e) {
            System.out.println("Error getting stocks: " + e);
        }

        return stocks;
    }
    

    public void updateStockQuantity(Stock stock, int quantity, boolean isBuy) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = db.getConnection();
            pstmt = conn.prepareStatement("UPDATE stocks SET quantity = ? WHERE symbol = ?");
            if (isBuy) {
            	System.out.println(stock.quantity()+"quantity of stock is this.");
                pstmt.setInt(1, stock.quantity() - quantity);
            } else {
                pstmt.setInt(1, stock.quantity() + quantity);
            }
            pstmt.setString(2, stock.symbol());
            pstmt.executeUpdate();
            System.out.println("Stock quantity updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    


}