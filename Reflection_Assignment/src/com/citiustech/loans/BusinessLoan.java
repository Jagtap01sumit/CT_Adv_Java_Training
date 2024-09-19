package com.citiustech.loans;

public class BusinessLoan implements BusinessIntrestRate{
	private double amount;
	private int duration;
	
	@Override
	public double BusinessRate(double amount, int duration) {
		// TODO Auto-generated method stub
		double rate =0;
		if(amount>250000) {
			rate=2.3;
		}else {
			rate=3.9;
		}
		 double emi = (amount + amount * rate) / duration;
		 return emi;
	}

}
