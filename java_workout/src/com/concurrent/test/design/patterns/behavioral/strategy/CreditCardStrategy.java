package com.concurrent.test.design.patterns.behavioral.strategy;

/**
 * Concrete strategy: pays using a credit card.
 */
public class CreditCardStrategy implements PaymentStrategy {
    private final String cardNumber;
    private final String cardHolder;

    public CreditCardStrategy(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        System.out.println("CreditCardStrategy: Paid $" + amount + " using card " + mask(cardNumber) + " for " + cardHolder);
    }

    private String mask(String number) {
        if (number == null || number.length() < 4) return "****";
        return "****-****-****-" + number.substring(number.length() - 4);
    }
}

