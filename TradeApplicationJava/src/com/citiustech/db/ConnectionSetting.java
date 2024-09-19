package com.citiustech.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.citiustech.stock.Stock;

public interface ConnectionSetting {
    final static String DB_URL = "jdbc:mysql://localhost:3306/stock_application";
    final static String DB_USERNAME = "root";
    final static String DB_PASSWORD = "root";
	
    Connection getConnection();

  

}
