package com.citiustech.payroll;

public class Manager implements Employee{

	@Override
	public double geNetIncome(int hours, float rate) {
		// TODO Auto-generated method stub
		return hours*rate;
	}

}
