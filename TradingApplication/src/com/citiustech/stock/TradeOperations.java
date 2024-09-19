package com.citiustech.stock;

import java.util.Map;

public interface TradeOperations {
	
	public void history(BaseEntity user);
	void buyStock(BaseEntity user, Stock stock, int quantity);
	void sellStock(BaseEntity user, Stock stock, int quantity);
	Map<String, Integer> portfolioValue(BaseEntity user);
}
