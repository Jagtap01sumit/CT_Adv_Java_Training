//package com.citiustech.stock;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public abstract class User_Management extends BaseEntity implements UserOperations {
//	
//	public static int nextId;
//	protected String email;
//	protected String name;
//	
//	private double balance;
//	public Map<String,Integer> portfolio = new HashMap<>();
//
//	
//	public double balance() {
//		return this.balance;
//	}
//	
//
//
//	public User_Management(String email, String name) {
//		// TODO Auto-generated constructor stub
//		super();
//		this.email = email;
//        this.name = name;
//        this.id = nextId++;
//	}
//
//	public int id() {
//		return id;
//	}
//	@Override
//	public abstract  void deleteUser(int id);
//		
//	
//	@Override
//	public abstract  void getAllUsers() ;
//		
//	
//	@Override
//	public abstract void updateUser(int id);
//		
//	
//	public String toString() {
//		return "UserId:"+this.id +" Email: "+ this.email+" name: "+this.name+"Create By:"+this.createdBy+"Create At:"+this.createdAt;
//	}
//	
////	public abstract void buyStock();
//	
//	public Map<String,Integer> showPortfolio() {
//		return portfolio;
//	}
//
//
//
//	public  String name() {
//		return name;
//	};
//	public String email() {
//		return email;
//	}
//
//}
