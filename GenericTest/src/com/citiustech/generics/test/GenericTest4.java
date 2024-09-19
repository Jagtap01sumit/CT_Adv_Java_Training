package com.citiustech.generics.test;
 
import com.citiustech.generics.Interval;
 
public class GenericTest4 {

	// Generic programming
	// Type Eraser -> Replacing Object by T
	private static<T extends Comparable<T>> T select(T first, T second) {//extends Comparable<T> => meaning=> the only datatype(Objects) allowed which extends from the comaparable interface;
		if(first.compareTo(second) > 0) {//javap -p java.lang.Integer
			return first;
		}
		return second;
	}

 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = select( "Monday", "Tuesday");
		System.out.printf("MAX string :  %s%n", ss);
		double sd = select( 4.0, 5.0);
		System.out.printf("MAX double :  %s%n", sd);
		
		//Interval si = select( new Interval(4, 50), new Interval(2, 40));  //its show error because above we mention that only comparable ele or the datatype that can be extends from Comparable<T> interface;
		//System.out.printf("MAX interval :  %s%n", si);//if we want to run this we need to implements the comparable interface in Interval class with method of compareTo() overriding
		
	}
}

