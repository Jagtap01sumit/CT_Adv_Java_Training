package com.citiustech.loans;

@Duration(max_duration=3)
public class HomeLoan extends LoanPolicys {
    private double amount;
    private int duration;

    @Override
    public double interestRate(double amount, int duration) {
        this.amount = amount;
        this.duration = validateDuration(duration);
        double rate = 0;
        if(amount>10000000) {
        	rate=0.50;
        } else {
        	rate =1.37;
        };
        double emiAmount = (amount + amount *rate) / duration;
        return emiAmount;
    }

    private int validateDuration(int duration) {
        Duration d = getClass().getAnnotation(Duration.class);
        int max = d.max_duration();
        return Math.min(duration, max);
    }
}