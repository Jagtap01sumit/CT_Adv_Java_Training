
package com.citiustech.loans;

@Duration(max_duration=5)
public class CarLoan extends LoanPolicys {
    private double amount;
    private int duration;

    @Override
    public double interestRate(double amount, int duration) {
        this.amount = amount;
        this.duration = validateDuration(duration);
        System.out.println(this.duration);
        double emi= (amount + amount * 0.229) / duration;
        return emi;
    }

    private int validateDuration(int duration) {
        Duration d = getClass().getAnnotation(Duration.class);
        int max = d.max_duration();
        System.out.printf("max_duration:%d%n",max);
        return Math.min(duration, max);
    }
}
