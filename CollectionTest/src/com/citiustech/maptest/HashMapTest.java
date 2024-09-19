package com.citiustech.maptest;

import java.util.HashMap;
import java.util.Map;

import com.citiustech.listtest.Interval;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		var store = new HashMap<String,Interval>();
		store.put("Monday", new Interval(4,5));
		store.put("Tuesday", new Interval(7,8));
		store.put("Wednesday", new Interval(2,4));
		store.put("Thursay", new Interval(1,6));
		store.put("Tuesday", new Interval(9,1));
		
		Interval value= store.get("Wedensday");
		if(value!=null) {
			System.out.printf("Minutes=%d%n",value.minutes());
		}
		
//		for(Map.Entry<String, Interval> entry:store.entrySet()) {
		for(var entry:store.entrySet()) {
			System.out.printf("%s=>%s%n",entry.getKey(),entry.getValue());
		}
				
	}

}
