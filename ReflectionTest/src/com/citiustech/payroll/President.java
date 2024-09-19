package com.citiustech.payroll;

public class President {
	private int hours;
	private float rate;
	
	
	public double getProfitPercent(int hours, float rate) {
		return rate*hours+100000;
		
	}
}
