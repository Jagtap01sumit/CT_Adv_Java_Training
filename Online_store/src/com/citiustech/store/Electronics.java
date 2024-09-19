package com.citiustech.store;


public class Electronics extends Product implements DiscountStrategy {
    private int warrantyPeriod = 3;
    private double discountPercentage;
    private double finalPrice;

    public Electronics(String name, double price) {
        super(name, price);
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