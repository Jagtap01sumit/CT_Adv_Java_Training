package com.citiustech.bank;

public abstract class Account {
	int id;
	protected double balance;
	
	public int id() {
		return id;
	}
	public double balance() {
		return balance;
	}
	
	public abstract void withdraw(double amount) throws InsufficientFundsException;
	
	public abstract void deposit(double amount);
	
	public final void transfer(double amount, Account other) throws InsufficientFundsException {
		if(this==other) throw new IllegalTransferException();
		this.withdraw(amount);
		other.deposit(amount);
	}
	
}
