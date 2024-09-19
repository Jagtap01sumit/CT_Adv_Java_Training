package com.citiustech.algorithm;
//flow
//shubham->sumit->levin->devang->manisha->promax
public class Algorithm {
	private Algorithm() {}//we make constructor private so no one can create a obj.=> because we want to access this method sonly using class name=> Algorithm.printall()

	public static void printAll(int [] numbers) {
		for(int value:numbers) {
			System.out.printf("%d ",value);
		}
		System.out.println();
	}
	
//	public static void printEven(int [] numbers) {
//		for(int value:numbers) {
//			if(value%2==0) {  // its wrong because if we want a prime or odd or any then need to duplicate the code and change small logic ...so it tighty coupled....and rigid
//				System.out.printf("%d ",value);
//			}
//		}
//		System.out.println();
//	}
	
	
//	public static void printEven(int [] numbers, Sumit st) {
//		for(int value:numbers) {
//			if(st.isEven(value) {  // its wrong because if we want a prime or odd or any then need to duplicate the code and change small logic ...so it tighty coupled....and rigid
//				System.out.printf("%d ",value);
//			}
//		}
//		System.out.println();
//	}
	
	
	public static void printIf(int[] numbers, Filter check) {
		for (int value : numbers) {
			if(check.allowed(value))
				System.out.printf("%d ", value);
		}
		System.out.println();
	}
}