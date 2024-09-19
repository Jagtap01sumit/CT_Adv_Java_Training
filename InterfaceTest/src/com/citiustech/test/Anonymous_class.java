package com.citiustech.test;

import com.citiustech.algorithm.Algorithm;
import com.citiustech.algorithm.Filter;

public class Anonymous_class {
	public static void main(String [] args) {
		int [] numbers = {1,2,3,4,5,6};
		//Local Inner Anonymous class
		//advantage=> can implement the class where it is required;
		Filter filter = new Filter() {

			@Override
			public boolean allowed(int value) {
				// TODO Auto-generated method stub
				return value>5;
			}
			
		};
		Algorithm.printIf(numbers, filter);
	}
}
