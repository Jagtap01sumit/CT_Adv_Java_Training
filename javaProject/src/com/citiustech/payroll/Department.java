package com.citiustech.payroll;

 
public class Department {
	private static int nextDeptId=0;
	private int deptId;  
	private String deptName;
	private String deptLocation;
	private int size;
	private Employee [] employees;
	private static int nextCount;
	private int count;
	

	public Department() {
		// TODO Auto-generated constructor stub  
		this(10, "IT", "pune");
		
		
	}
	public Department(int size, String deptName, String deptLocation) {
		// TODO Auto-generated constructor stub
		
		
		
		deptId= nextDeptId++;
		count=nextCount++;
		
		this.deptName=deptName;
		this.deptLocation=deptLocation;
		this.employees = new Employee[size];
		
	}
	public int getDeptId() {
		return deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public String getDeptLocation() {
		return deptLocation;
	}
	public int getSize() {
		return size;
	}
	public Employee[] getEmployees() {
		return employees;
	}

	 public void hireEmployee(Employee emp) {
	        if (count < employees.length) {
	            employees[count] = emp;
	            count++;
	        } else {
	        	throw new HiringPositionFilledExeption();
	        }
	    }

	public String toString() {
		return String.format( "deptId:%d, deptName : %s, deptLocation: %s",this.deptId,deptName,deptLocation);
	}
}
