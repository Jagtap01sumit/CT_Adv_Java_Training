
package com.citiustech.test;

import java.lang.reflect.Method;
import java.util.Scanner;

import com.citiustech.loans.CarLoan;
import com.citiustech.loans.Duration;
import com.citiustech.loans.LoanPolicys;

public class Loans {

    public static void main(String[] args) {
        try {
        	
        	Scanner sc= new Scanner(System.in);
        	System.out.println("Enter class name:");
            String loanType = sc.next();
            System.out.println("Enter method name");
            String methodName = sc.next();
            System.out.println("Enter Loan amount:");
            double amount = sc.nextDouble();
            System.out.println("Enter duration :");
            int duration = sc.nextInt();

            var c = Class.forName("com.citiustech.loans." + loanType);
            Object newLoan = c.getConstructor().newInstance();

            var method = c.getMethod(methodName, double.class, int.class);

            if (c.isAnnotationPresent(Duration.class)) {
                Duration maxDuration = (Duration) c.getAnnotation(Duration.class);
                if (duration > maxDuration.max_duration()) {
                    duration = maxDuration.max_duration();
                    System.out.printf("Max duration for %s is %d years %n",loanType, duration);
                }
            }

            double interestRate = (double) method.invoke(newLoan, amount, duration);
            System.out.printf("Interest rate for %s of amount %.2f for %d years is: %.2f per year %n", loanType, amount, duration, interestRate);
        } catch (Exception e) {
            System.out.printf("ERROR: %s%n", e.getMessage());
        }
    }
}