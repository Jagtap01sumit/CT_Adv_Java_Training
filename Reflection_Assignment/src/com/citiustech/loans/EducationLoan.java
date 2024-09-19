
// EducationLoan class
package com.citiustech.loans;

@Duration(max_duration=5)
public class EducationLoan extends LoanPolicys {
    private double amount;
    private int duration;

    @Override
    public double interestRate(double amount, int duration) {
        this.amount = amount;
        this.duration = validateDuration(duration);
        
        double emi = (amount + amount * 0.19) / duration;
        return emi;
    }

    private int validateDuration(int duration) {
        Duration annotation = getClass().getAnnotation(Duration.class);
        int max = annotation.max_duration();
        return Math.min(duration, max);
    }
}