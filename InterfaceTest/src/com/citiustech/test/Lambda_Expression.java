package com.citiustech.test;

import com.citiustech.algorithm.Algorithm;
import com.citiustech.algorithm.Filter;

public class Lambda_Expression {
	
	
	public static void main(String [] args) {
		int [] numbers = {1,2,3,4,5,6};
		
		


			
	//Lambda Expression -> will work with functional interface
		Algorithm.printIf(numbers, value->value<4);
	}
}

/*
 * class SomeRuntimeClass implements Filter{
 *		 
 * }
 */