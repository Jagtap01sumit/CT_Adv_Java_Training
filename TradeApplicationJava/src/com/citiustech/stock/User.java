package com.citiustech.stock;

import java.util.HashMap;
import java.util.Map;

class User extends BaseEntity {
	private String email;
	private String name;
	public Map<String, Integer> portfolio;

	public User(String email, String name, Map<String, Integer> portfolio) {
		this.email = email;
		this.name = name;
		this.portfolio = portfolio;
	}

	public int userId() {
		return id;
	}

	public Map<String, Integer> showPortfolio() {
		return portfolio;
	}

	public void savePortfolio(Map<String, Integer> map) {
		this.portfolio = map;
	}

	public String name() {
		return name;
	};

	public String email() {
		return email;
	}

	

	public void buyStock() {
		portfolio.put("newstock", 19000);
	}

}
