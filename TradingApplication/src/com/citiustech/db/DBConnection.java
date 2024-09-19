package com.citiustech.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements ConnectionSetting {
	 protected static Connection connection;

	    @Override
	    public  Connection getConnection() {
	        try {
	            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	            return connection;
	        } catch (SQLException e) {
	            throw new RuntimeException("Error establishing database connection", e);
	        }
	    }
}
