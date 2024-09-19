package com.citiustech.test;

import com.citiustech.algorithm.Algorithm;
import com.citiustech.algorithm.Filter;

public class Method_referance {
	
	public static boolean isLessThan(int value) {
		return value<4;
	}
	public static void main(String [] args) {
		int [] numbers = {1,2,3,4,5,6};
		
		//METHOD Reference => allows to pass ref of the method
		//-Function interface=> the interface having only having one method .


			
	
		Algorithm.printIf(numbers, Method_referance::isLessThan);
		//Algorithem.printIf(numbers, new SomeRuntimeClass());
	}
}

/*
 * class SomeRuntimeClass implements Filter{
 *		 
 * }
 */
