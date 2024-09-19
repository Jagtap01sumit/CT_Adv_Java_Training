package com.citiustech.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.CallableStatement;
public class StoreProcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String customerId="CU302";
		int productNo=302;
		int quantity=9;
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");//it not req...bucause below url automatically load this driver;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "root");
			try {
				con.setAutoCommit(false);
				CallableStatement cstmt= con.prepareCall("{call place_order(?,?,?,?)}");
				 cstmt.setString(1, customerId);
				 cstmt.setInt(2, productNo);
				 cstmt.setInt(3, quantity);
				 cstmt.registerOutParameter(4, Types.INTEGER);
				 cstmt.execute();
				 
				 int orderNo=cstmt.getInt(4);
				 System.out.printf("New order number=%d%n",orderNo);
			}catch(SQLException e){
				con.rollback();
				System.out.println("Order Failed!");
			}finally {
			
				con.close();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

//preparedStatement => plan was created once only replace the values;
//createStatement=> plan was created every time
