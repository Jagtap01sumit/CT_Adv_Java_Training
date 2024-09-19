package com.citiustech.test;

import com.citiustech.objectidentity.Interval;

public class ObjectIdentityTest {
	public static void main(String[] args) {
		Interval a = new Interval(4,5);
		Interval b = new Interval(4,5);
		Interval c = a;
		
		System.out.printf("a identical to b: %b%n", a==b);
		System.out.printf("c identical to a: %b%n", c==a);

		System.out.printf("a equal to b %b%n", a.hashCode()==b.hashCode()&& a.equals(b) );
		

	}
}
