package com.citiustech.jdbctest;
// download sql file=>https://dev.mysql.com/downloads/mysql/8.0.html
//create file Data and inside it db in c drive
//in cmd => cd C:\downloads\mysql-8.0.39-winx64\bin>
//initialize the sql server=>mysqld.exe --initialize =>path and command
//>mysql.exe -u root -p  < C:\downloads\salesmy2.sql //in other cmd, this insert this file and data in sql having db sales;
//show databases;
//use sales
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class QueryTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//as same like reflection project...we just get classname at runtime
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "root");//here we just create new obj and instatnce Connection con = new Connectio.....something like that but we put absract the implementation...so DriverManager is like extra layer to create a instatnce which return a new instatnce;
			//here we use DriverManager it is same like Banker....we not directly create new Customer() for this we use Banker...other info to create new Instatnce is abstracted class are not public.
			try {
				System.out.println("Connection opened");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select pno,price,stock from products");
				while(rs.next()) {//rs.next=> send a fetch req . then server send one row..if we not use next() then server not send data. its IMP.
					System.out.printf("%d\t%.2f\t%d%n",rs.getInt(1),rs.getFloat(2),rs.getInt(3));//this number whill be the column indx , the idx of column start from 1 not from zero;
				}
				rs.close();
				stmt.close();
			}finally {
				con.close();
			}//this is try with finally
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

//executeUpdate=>insert
//executeQuery=>select








//A->automicity=>
//C->consistency
//I->
//D->