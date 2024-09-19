package com.citiustech.payrolltest;

import com.citiustech.payroll.Clerk;
import com.citiustech.payroll.Employee;
import com.citiustech.payroll.Manager;
import com.citiustech.payroll.President;

public class PayrollTest {
	public static void main(String[] args)  {
//	Employee clerk = new Clerk();
//	System.out.printf("Net Income of Clerk: %.2f%n", clerk.geNetIncome(10, 90));
//	
//	Employee manager = new Manager();
//	System.out.printf("Net Income of manger: %.2f%n", manager.geNetIncome(20, 90));
//	
//	President pr = new President();
//	System.out.printf("Net Income of Presedent: %.2f%n", pr.getProfitPercent(10, 90));

		//this all are rigid we need to call same type method again again;
		
		
		
		
		//now this is flexile and working for any employee type...only   
//		Class<?> c = Class.forName(args[0]);
//		try {
//		Class<?> c = Class.forName("com.citiustech.payroll.Manager");
//		Employee emp =(Employee) c.getConstructor().newInstance();
//		double income= emp.geNetIncome(100,200);
//		System.out.printf("Income=%.2f%n",income);
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		
		
		
		//this is lossely coupled ..... any type of employee can pass through this method
		try {
		var c = Class.forName(args[0]);//class name 
		Object emp = c.getConstructor().newInstance();
		var m =c.getMethod(args[1],int.class,float.class);//method name of this class
		double income=(double) m.invoke(emp, 200,100);
		System.out.printf("Income=%.2f%n",income);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
