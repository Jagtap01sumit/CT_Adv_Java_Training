package com.citiustech.filetest;

import java.io.Serializable;

public class Employee implements Serializable{

	private String name;
	private double salary;
	private int id;
	private static int count;
	
	public Employee(String name, double salary) {
		// TODO Auto-generated constructor stub
		this.id = this.count;
		this.name = name;
		this.salary = salary;
		count++;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
		this("Jack",45000);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Name: %s \t Salary : %.2f",name,salary);
	}
	
}
