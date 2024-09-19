package com.citiustech.payroll;


@Bonus(20000)//@Bonus(value=200000)   //if we not metion value like(@Bonus) then it apply default value which is 10000;
public class Clerk implements Employee{


	public double geNetIncome(int hours, float rate) {
		// TODO Auto-generated method stub
		return hours*rate;
	}

}
