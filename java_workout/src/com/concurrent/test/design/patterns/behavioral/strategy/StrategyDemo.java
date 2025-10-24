package com.concurrent.test.design.patterns.behavioral.strategy;

/**
 * Demo for Strategy pattern (Payment strategies).
 */
public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new ShoppingCart.Item("Book", 12.99));
        cart.addItem(new ShoppingCart.Item("Pen", 1.49));

        PaymentStrategy cc = new CreditCardStrategy("1234567812345678", "Alice");
        cart.pay(cc);

        PaymentStrategy paypal = new PaypalStrategy("alice@example.com");
        cart.pay(paypal);
    }
}

