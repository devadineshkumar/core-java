package com.concurrent.test.design.patterns.behavioral.strategy;

/**
 * Strategy interface: defines the payment operation contract.
 */
public interface PaymentStrategy {
    void pay(double amount);
}

