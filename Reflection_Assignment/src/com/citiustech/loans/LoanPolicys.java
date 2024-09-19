package com.citiustech.loans;

public abstract class LoanPolicys {
	protected double amount;
	protected int duration;
	
	public abstract double interestRate(double amount, int duration);
}
