package com.citiustech.reftest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
///declarative programming
public class StreamAPITest {
	//this is normal way to search by brand
//	public static String searchByBrand(Item[] arr) {
//		for(Item item:arr) {
//			if(item.brand()=="Samsung") {
//				System.out.println(item.name());
//				return item.name();
//			}
//		}
//		return null;
//	}
	
	
	
		public static void main(String[] args) {
			Shop shop=new Shop();
//			StreamAPITest.searchByBrand(t.getItems());
			
			
			//this is more efficient way to print items having brand samsung;
			Item[] items = shop.getItems();
			List<String> names = Arrays.stream(items)
					.filter(i->i.brand().equals("Samsung"))
					.map(i->i.name())
					.collect(Collectors.toList());
			for(String name:names) {
				System.out.println(name);
			}
			
			//-----declarative programming=> focus is on task what we want to print
			 Arrays.stream(items)
				.filter(i->i.brand().equals("Samsung"))
				.map(i->i.name())
				.forEach(System.out::println);
			
		}
}
