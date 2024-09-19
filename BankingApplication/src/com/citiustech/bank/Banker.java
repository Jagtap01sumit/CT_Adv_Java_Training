package com.citiustech.bank;

public class Banker {
	private static int nextId;
	
	static {
		nextId=(int) System.currentTimeMillis()%1000000;
		
	
	}
	
	private Banker() {};
	
	public static Account openSavingsAccount() {
		Account acc = new SavingsAccount();
		acc.id=++nextId;
		return acc;
	}
	
	public static Account openCurrentAccount() {
		Account acc= new CurrentAccount();
		acc.id=++nextId;
		return acc;
		
	}
}
