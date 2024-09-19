package com.citiustech.payroll;

public class Employee {
	private static int nextEmpId=0;
	private int empId;
	private int hours;
	private String name;
	private float rate;
	public Employee() {
		// TODO Auto-generated constructor stub
		this("SUMIT",90,70);
	}
	public Employee(String name,int hours, float rate) {
		empId=nextEmpId++;
		this.name= name;
		this.hours=hours;
		this.rate=rate;
		
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	public String toString() {
		return String.format("%d\t%.2f%n",hours,rate);
	}
	public double netIncome() {
		return hours*rate;
	}
	
	public String getEmpDetails() {
		return String.format("Emp Id : %d Total Net Income %.2f ",empId,netIncome());
	}
	
}
