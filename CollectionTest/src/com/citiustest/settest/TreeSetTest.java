package com.citiustest.settest;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


//when we directly implement Treeset it need to be a Interval class implements comparable...thus we implement in Interval Class;
public class TreeSetTest {
	public static class IntervalComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval a, Interval b) {
			// TODO Auto-generated method stub
			return a.seconds()- b.seconds();
		}
		
	}
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		
		
		//if we use set it add duplicates also , thus we need to override hashcode and equality so we set this explicitely so it can compare.
		//Set<Interval> store = new TreeSet<>();
		
		//if you dont want to write it explecitly then u can write internal class where u mention this compareator method in constructor and pass the obj of comparator. like,
		//first we write nested class => above main method
//		Set<Interval> store = new TreeSet<>(new IntervalComparator());
		
		//if you dont want to create new class comparator then u can use lambda expression, like
		Set<Interval> store = new TreeSet<>((a,b)->a.seconds()-b.seconds());
		
		
		
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
