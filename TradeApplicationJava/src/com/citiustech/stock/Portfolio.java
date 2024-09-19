package com.citiustech.stock;

import java.util.Map;

public class Portfolio {
	
		public static void myPortfolio(BaseEntity bs) {
			User castedUser= (User) bs;
			Map<String,Integer> map = castedUser.showPortfolio();
			for(String stock:map.keySet()) {
				System.out.println("hello");
				System.out.println(stock +"|"+ map.get(stock));
			}
		}
}
