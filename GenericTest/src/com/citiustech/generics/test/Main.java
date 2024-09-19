package com.citiustech.generics.test;

import com.citiustech.generics.Employee;
import com.citiustech.generics.SimpleStack;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimpleStack<Employee> e= new SimpleStack<>(10);

	  
		
		
	    e.push("SUMIT");
	    e.push("AMIT");
	    
	   
	    e.pop();
	  

	    e.display();
	}
}