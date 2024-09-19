package com.citiustech.test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime currentTime=LocalDateTime.now();
		System.out.println(currentTime);
	
//		ZonedDateTime zonedDateTime = currentTime.atZone("");
//------------------------------------------------------------------------------------------------------------------	
//		String roomType="Economy";
//		int rate=switch(roomType) {
//		case "Economy" -> 950;
//		case "Business"->1200;
//		default -> 1500;
//		};
//		System.out.printf("Rate=%d%n",rate);
		
		
		System.out.println("Menu:");
		System.out.println("1.Economy");
		System.out.println("2.usiness");
		System.out.println("3.Executive");
		System.out.println("4.Deluxe");
		
		
//		Scanner sc =new Scanner(System.in);
//		System.out.println("Enter your requirement");
//		String roomType=sc.next();
//		System.out.println("Enter number of days:");
//		String days=sc.next();
//		int rate=switch(roomType) {
//		case "Economy" -> 950;
//		case "Business"->1200;
//		default -> 1500;
//		};
//		double ans =rate * days * 1.1;
//		System.out.println(ans);
		
//--------------------------------------------------------------------------------------------------------------
		//imutable list
		List<String> paymentMethod = List.of("CASH","CHEQUE","CARD");
//		paymentMethod.remove(1);
//		paymentMethod.add("UPI");
//-----------------------------------------------------------------------------------------------------------------
		System.out.println("<html>");
        System.out.println("  <head>");
        System.out.println("    <title>Index - Test Application");
        System.out.println("  </head>");
        System.out.println("  <body>");
        System.out.println("  </body>");
        System.out.println("</html>");	
        
//------------------------------------------------------------------------------------------------------------------ 
        
        //we control the extension......for classesss when it sealed only permited class can extends this class
        //if it non-sealed then anyone can extends and if it final no one can extends this class;
        
//        sealed class Account permits SavingAccount,CurrentAccount{
//        	public void withdraw() {}
//        }
//        
//        non-sealed class SavingAccount extends Account{
//        	
//        }
//        
//        final class CurrentAccount extends Account{
//        	
//        }
//--------------------------------------------------------------------------------------------------------------
        
        
//        abstract class Employee{
//        	abstract double getNetIncome();
//        }
//
//        class Dealer extends E  Employee{
//        	
//        	@Override
//        	public double getNetIncome() {
//        		return 7000;
//        	}
//        }
//
//        class SalesPerson extends Employee{
//        	
//        	@Override
//        	public double getNetIncome() {
//        		return 7000;
//        	}
//        	
//        	public double getSales() {
//        		return 50000;
//        	}
//        }
//        public class Test {
//
//        	private static void handleEmployee(Employee emp) {
//        		switch(emp) {
//        		case Dealer d -> {
//        			d.getNetIncome();
//        		}
//        		case SalesPerson s -> {
//        			s.getNetIncome();
//        			s.getSales();
//        		}
//        		default -> System.out.println("Unknown employee");
//        		}
//        	}
//        	
//        	
//        }
	}

}
