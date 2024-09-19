package com.citiustech.reftest;


record Item(String name, String brand) {}//when we use record compiler write code which is Item class which is immutable;
public class Shop {
	public Item[] getItems() {
		return new Item[] {
				new Item("cpu","Intel"),
				new Item("monitor","Samsung"),
				new Item("mouse","Logitech"),
				new Item("ssd","Samsung"),

		};
	}
}
