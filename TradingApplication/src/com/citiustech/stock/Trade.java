package com.citiustech.stock;

import java.util.Date;

 class Trade extends BaseEntity {
	 public static int nextId;
   
    private int userId;
    public Stock stock;
    private int quantity;
    private String tradeType;
    private Date timeStamp;

    Trade(int userId, Stock stock, int quantity, String tradeType ) {
		super();

        this.id = nextId++;
        this.userId = userId;
        this.stock = stock;
        this.quantity = quantity;
        this.tradeType = tradeType;
        this.timeStamp = new Date(); 
    }

    
    public  int id() {
		return id;
	}


	public int userId() {
		return userId;
	}


	public Stock stock() {
		return stock;
	}


	public int quantity() {
		return quantity;
	}


	public String tradeType() {
		return tradeType;
	}


	public Date timeStamp() {
		return timeStamp;
	}


	public String toString() {
    	return "Id:"+id+"| "+" user_id: "+ id+"| "+" Stock: "+stock.symbol()+ "| quantity: "+quantity +"| trade type:"+ tradeType+ " Time: "+timeStamp;
    }
}