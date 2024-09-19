package com.citiustech.test;

import com.citiustech.algorithm.Algorithm;
import com.citiustech.algorithm.Filter;

public class SumitTest implements Filter{

//	public boolean isEven(int value) {
//		return value % 2 == 0; 
//	}
	
	public boolean allowed(int value) {
		// TODO Auto-generated method stub
		return value % 2 == 0; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		//Algorithm.printEven(numbers);
		Algorithm.printIf(numbers, new SumitTest()); //but it regid because it only for sumitTest
	}

}
