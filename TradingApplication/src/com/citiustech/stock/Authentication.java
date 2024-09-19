package com.citiustech.stock;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashMap;

import com.citiustech.db.ConnectionSetting;
import com.citiustech.db.DBConnection;
import com.citiustech.exceptions.LoginException;
import com.citiustech.exceptions.UserAlreadyExistException;
import com.mysql.cj.jdbc.CallableStatement;
import java.util.*;
public  class Authentication  {
static DBConnection db = new DBConnection();
		private Authentication() {
			
		}
		
		public static User createNewUser(String email,String name) {
			User  createNewUser = new User(email,name, new HashMap<>());
			
		
			saveUser(createNewUser);
			
			return createNewUser;
		}
		
		public static User loginUser(String email, String name) {
			Map<String,Integer> map = new HashMap<>();
			if (loginUserDB(email, name)) {
	            return new User(email, name,map);
	        } else {
	            return null;
	        }
		}
		public static void getUserInfo(User user) {
			System.out.println(user.toString());
		}

	public void createGetNextIdProcedure() {
		try (Statement statement = db.getConnection().createStatement()) {
			statement.executeUpdate("DROP PROCEDURE IF EXISTS sp_get_next_id_users");
			statement.executeUpdate("CREATE PROCEDURE sp_get_next_id_users(OUT next_id INT) " + "BEGIN "
					+ "    UPDATE counter SET current_count = current_count + 1 where table_name='users'; "
					+ "    SET next_id = (SELECT current_count FROM counter WHERE table_name='users' ); " + "END");
		} catch (SQLException e) {
			System.out.println("Error creating procedure: " + e.getMessage());
		}
	} 
		
		public static void saveUser(User user) {
			try (java.sql.CallableStatement statement = db.getConnection().prepareCall("CALL sp_get_next_id_users(?)")) {
				statement.registerOutParameter(1, Types.INTEGER);
				statement.execute();
				int nextId = statement.getInt(1);
	
				try (PreparedStatement existingUserStatement = db.getConnection()
						.prepareStatement("SELECT 1 FROM users WHERE email = ?")) {
					existingUserStatement.setString(1, user.email());
					try (ResultSet resultSet = existingUserStatement.executeQuery()) {
						if (resultSet.next()) {
							throw new UserAlreadyExistException("User with email " + user.email() + " already exists");
						}
					}
				}
	
				try (PreparedStatement preparedStatement = db.getConnection()
						.prepareStatement("INSERT INTO users (id, name, email) VALUES (?, ?, ?)")) {
					preparedStatement.setInt(1, nextId);
					preparedStatement.setString(2, user.name());
					preparedStatement.setString(3, user.email());
					preparedStatement.executeUpdate();
				}
			} catch (SQLException e) {
				System.out.println("Error saving user: " + e.getMessage());
			}
		}
	public static boolean loginUserDB(String email,String name) {
    try (PreparedStatement existingUserStatement = db.getConnection().prepareStatement("SELECT 1 FROM users WHERE email = ? and name = ?")) {
        existingUserStatement.setString(1, email);
        existingUserStatement.setString(2, name);

        try (ResultSet resultSet = existingUserStatement.executeQuery()) {
            if (resultSet.next()) {
                return true;
            }
        }
    } catch (SQLException e) {
        throw new LoginException("Error logging in user: " + e.getMessage(), e);
    }
    return false;
}
		
}
