package com.citiustech.jdbctest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParamSQLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String customerId="CU902";
		int productNo=302;
		int quantity=9;
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");//it not req...bucause below url automatically load this driver;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "root");
			try {
				con.setAutoCommit(false);
				Statement stmt = con.createStatement();
				stmt.executeUpdate("update counters set cur_val= cur_val+1 where ctr_name='orders'");
				ResultSet rs = stmt.executeQuery("select cur_val+1000 from counters where ctr_name='orders'");
				rs.next();
				int orderNo=rs.getInt(1);
				Date today = new Date(System.currentTimeMillis());
				PreparedStatement pstmt= con.prepareStatement("insert into orders values(?,?,?,?,?)");
				pstmt.setInt(1, orderNo);
				pstmt.setDate(2, today);
				pstmt.setString(3, customerId);
				pstmt.setInt(4, productNo);
				pstmt.setInt(5, quantity);
				pstmt.executeUpdate();
				
				pstmt.close();
				rs.close();
				stmt.close();
				con.commit();
				
				System.out.printf("New order numbre=%d%n",orderNo);
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
