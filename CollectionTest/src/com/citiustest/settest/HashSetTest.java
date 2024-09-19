package com.citiustest.settest;

import java.util.HashSet;
import java.util.Set;



//VIMP => what is obj identity and equality => how to find it identical => using == , 
//how to find equality=> first hashcode should match then data should match;

public class HashSetTest {
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		
		Set<Interval> store = new HashSet<>();//if we use set it add duplicates also , thus we need to override hashcode and equality so we set this explicitely so it can compare.
		store.add(new Interval(14,2));
		store.add(new Interval(9,4));
		store.add(new Interval(5,3));
		store.add(new Interval(20,7));
		store.add(new Interval(11,1));
		store.add(new Interval(9,4));
		for (Interval interval : store) {
			System.out.println(interval);
		}
		
	}
}
