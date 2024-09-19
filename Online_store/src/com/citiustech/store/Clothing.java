package com.citiustech.store;
public class Clothing extends Product implements DiscountStrategy {
    private String size;
    private String season;
    private int warrantyPeriod = 2;
    private double discountPercentage;
    private double finalPrice;

    public Clothing(String name, double price, String size, String season) {
        super(name, price);
        this.size = size;
        this.season = season;
    }

    @Override
    public void applyDiscount() {
        this.discountPercentage = 0.2;
        calculateFinalPrice();
    }

    @Override
    public double calculateFinalPrice() {
        if (finalPrice == 0) {
            if (warrantyPeriod >= 1) {
                this.finalPrice = this.price - (this.price * discountPercentage);
            } else {
                this.finalPrice = this.price;
            }
        }
        return finalPrice;
    }
}