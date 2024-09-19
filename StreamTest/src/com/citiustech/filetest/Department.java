package com.citiustech.filetest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable{

	private static int deptCounter;
	private int deptId;
	private String deptName;
	private String deptLocation;
	private int deptSize;
	private static int count;
	
	List<Employee> store = new ArrayList<>();;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String deptName, String deptLocation,int deptSize) {
		this.deptName = deptName;
		this.deptLocation = deptLocation;
		this.deptSize = deptSize;
		this.deptCounter++;
		this.deptId = this.deptCounter;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLocation() {
		return deptLocation;
	}

	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}
	
	public boolean hireEmployee(Employee emp) {
		if(count<deptSize) {
			store.add(emp);
			count++;
			return true;
		}
		return false;
	}
	
	public Employee getEmployee() {
		return store.get(count);
	}
	
	public void printEmp() {
		for(Employee emp : store) {
			if(emp!= null) {
				System.out.println(emp.toString());
			}
		}
	}
	
	
	public String toString() {
		// TODO Auto-generated method stub
		return String.format(" Department Id : %d%n Department Name: %s%n Department Location : %s%n Department Size : %d%n", deptId,deptName,deptLocation, deptSize);
	}
	
}
	
