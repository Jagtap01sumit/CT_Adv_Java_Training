//package com.citiustech.db;
//
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Types;
//
//import com.citiustech.exceptions.LoginException;
//import com.citiustech.exceptions.UserAlreadyExistException;
//import com.citiustech.stock.Authentication;
//import com.citiustech.stock.User_Management;
//
////when user already in the users then throw excption;
//public class UserDB extends ConnectionSetting {
//	private Connection connection;
//
//	public UserDB() {
//		try {
//			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//			createProcedure();
//			createGetNextIdProcedure();
//		} catch (SQLException e) {
//			System.out.println("Error connecting to database: " + e.getMessage());
//		}
//	}
//
//	public void createProcedure() {
//		try (Statement statement = connection.createStatement()) {
//			statement.executeUpdate("DROP PROCEDURE IF EXISTS sp_save_user");
//			statement.executeUpdate(
//					"CREATE PROCEDURE sp_save_user(IN name VARCHAR(255), IN email VARCHAR(255), OUT id INT) " + "BEGIN "
//							+ "    INSERT INTO users (name, email) VALUES (name, email); "
//							+ "    SET id = LAST_INSERT_ID(); " + "END");
//		} catch (SQLException e) {
//			System.out.println("Error creating procedure: " + e.getMessage());
//		}
//	}
//
//	public void createGetNextIdProcedure() {
//		try (Statement statement = connection.createStatement()) {
//			statement.executeUpdate("DROP PROCEDURE IF EXISTS sp_get_next_id_users");
//			statement.executeUpdate("CREATE PROCEDURE sp_get_next_id_users(OUT next_id INT) " + "BEGIN "
//					+ "    UPDATE counter SET current_count = current_count + 1 where table_name='users'; "
//					+ "    SET next_id = (SELECT current_count FROM counter WHERE table_name='users' ); " + "END");
//		} catch (SQLException e) {
//			System.out.println("Error creating procedure: " + e.getMessage());
//		}
//	} 
//
////	public boolean loginUser(String email,String name) {
////	    try (PreparedStatement existingUserStatement = connection.prepareStatement("SELECT 1 FROM users WHERE email = ? and name = ?")) {
////	        existingUserStatement.setString(1, email);
////	        existingUserStatement.setString(2, name);
////
////	        try (ResultSet resultSet = existingUserStatement.executeQuery()) {
////	            if (resultSet.next()) {
////	                return true;
////	            }
////	        }
////	    } catch (SQLException e) {
////	        throw new LoginException("Error logging in user: " + e.getMessage(), e);
////	    }
////	    return false;
////	}
//
//	public class LoginException extends RuntimeException {
//	    public LoginException(String message, Throwable cause) {
//	        super(message, cause);
//	    }
//	}
//
////	public void saveUser(User user) {
////		try (CallableStatement statement = connection.prepareCall("CALL sp_get_next_id_users(?)")) {
////			statement.registerOutParameter(1, Types.INTEGER);
////			statement.execute();
////			int nextId = statement.getInt(1);
////
////			try (PreparedStatement existingUserStatement = connection
////					.prepareStatement("SELECT 1 FROM users WHERE email = ?")) {
////				existingUserStatement.setString(1, user.email());
////				try (ResultSet resultSet = existingUserStatement.executeQuery()) {
////					if (resultSet.next()) {
////						throw new UserAlreadyExistException("User with email " + user.email() + " already exists");
////					}
////				}
////			}
////
////			try (PreparedStatement preparedStatement = connection
////					.prepareStatement("INSERT INTO users (id, name, email) VALUES (?, ?, ?)")) {
////				preparedStatement.setInt(1, nextId);
////				preparedStatement.setString(2, user.name());
////				preparedStatement.setString(3, user.email());
////				preparedStatement.executeUpdate();
////			}
////		} catch (SQLException e) {
////			System.out.println("Error saving user: " + e.getMessage());
////		}
////	}
//
////    public boolean loginUser(User_Management user) {
////    	 try (CallableStatement statement = connection.prepareCall("CALL sp_get_next_id_users(?)")) {
////             
////    }
//}