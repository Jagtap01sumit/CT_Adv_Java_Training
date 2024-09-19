package com.cititustech.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record Customer(int customerId, String name, int quantity, int rating) {}

public class Shop {
	 public static List<Customer> getAllCustomers(){
	        return new ArrayList<>(
	                Arrays.asList(
	                        new Customer(102, "Prathamesh", 30, 4),
	                        new Customer(101, "Sumit", 20, 3),
	                        new Customer(103, "Manisa", 40, 3),
	                        new Customer(104, "Ritesh", 60, 3)
	                )
	        );
	    }
	
		 public static void main(String[] args) {
			    List<Customer> customers = getAllCustomers();
			    
			    customers.stream()
			        .filter(customer -> customer.quantity() > 20)
			        .sorted((c1, c2) -> c1.name().compareTo(c2.name()))
			        .forEach(customer -> {
			            int rating = customer.rating();
			            String stars = "";
			            for (int i = 1; i <= rating; i++) {
			                stars += "*";
			            }
			            System.out.printf("Name: %s  Rating:%s%n",customer.name(),stars);
			        });
			}
}