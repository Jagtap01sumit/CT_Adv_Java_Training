package com.citiustech.stock;

public class Stock extends BaseEntity {
	public static int nextId;
	  private int id;
	    private String symbol;
	    private String companyName;
	    private double pricePerShare;
	    private int quantity;
	    // Constructor
	    public Stock( String symbol, String companyName, double pricePerShare, int quantity) {
			super();

	    	this.id=nextId++;
	        this.id = id;
	        this.symbol = symbol;
	        this.companyName = companyName;
	        this.pricePerShare = pricePerShare;
	        this.quantity=quantity;
	    }

	    public int id() {
	        return id;
	    }

	 
	    public String symbol() {
	        return symbol;
	    }

	   

	    public String companyName() {
	        return companyName;
	    }

	

	    public double pricePerShare() {
	        return pricePerShare;
	    }
	    public int quantity() {
	    	return quantity;
	    }


	
	
}
