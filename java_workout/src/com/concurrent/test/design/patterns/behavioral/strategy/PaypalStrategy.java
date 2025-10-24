package com.concurrent.test.design.patterns.behavioral.strategy;

/**
 * Concrete strategy: pays using PayPal.
 */
public class PaypalStrategy implements PaymentStrategy {
    private final String email;

    public PaypalStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("PaypalStrategy: Paid $" + amount + " using PayPal account " + email);
    }
}

