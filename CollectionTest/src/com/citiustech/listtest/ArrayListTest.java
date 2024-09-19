package com.citiustech.listtest;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	
		public static void main(String [] args) {
			List<Interval> store = new ArrayList<>();
			store.add(new Interval(14,2));
			store.add(new Interval(9,4));
			store.add(new Interval(5,3));
			store.add(new Interval(20,7));
			store.add(new Interval(11,1));
			
			for (Interval interval : store) {
				System.out.println(interval);
			}
			System.out.println(store.get(2));
		}

		
}
 