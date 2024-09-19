package com.citiustech.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.citiustech.stock.TradeManagement;

public class TradeDB  {
//	
//	private static void saveTradeToDB(TradeManagement trade) {
//	    Connection conn = null;
//	    PreparedStatement pstmt = null;
//	    ResultSet resultSet = null;
//
//	    try {
//	        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//
//	        
//
//	        pstmt = conn.prepareStatement("INSERT INTO trade_history (user_id, stock, quantity, trade_type) VALUES (?, ?, ?, ?)");
//	        pstmt.setInt(1, trade.user().getId());
//	        pstmt.setString(2, trade.getStock().getSymbol());
//	        pstmt.setInt(3, trade.getQuantity());
//	        pstmt.setString(4, trade.getTradeType());
//	        pstmt.executeUpdate();
//	        System.out.println("Trade saved successfully!");
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        try {
//	            if (resultSet != null) {
//	                resultSet.close();
//	            }
//	            if (pstmt != null) {
//	                pstmt.close();
//	            }
//	            if (conn != null) {
//	                conn.close();
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}

}
