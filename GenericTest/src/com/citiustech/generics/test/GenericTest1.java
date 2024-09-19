package com.citiustech.generics.test;

import com.citiustech.generics.Interval;

public class GenericTest1 {
	public static String select(int sign, String first,String second) {
		if(sign>0)
			return first;
		return second;
	}
	public static double select(int sign, double first,double second) {
		if(sign>0)
			return first;
		return second;
	}
	public static Interval select(int sign, Interval first,Interval second) {
		if(sign>0)
			return first;
		return second;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss= select(9,"Monday","Tuesday");
		System.out.printf("Selected string =%s%n",ss);
		
		double sd= select(-7,4.0,5.0);
		System.out.printf("Selected double =%s%n",sd);
		Interval si= select(5,new Interval(4,50),new Interval(2,40));
		System.out.printf("Selected double =%s%n",si);
	}
	
	
}
