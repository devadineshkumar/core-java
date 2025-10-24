package com.concurrent.test.design.patterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Context: holds items and delegates payment to a PaymentStrategy.
 */
public class ShoppingCart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) { items.add(item); }
    public void removeItem(Item item) { items.remove(item); }

    public double calculateTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public void pay(PaymentStrategy strategy) {
        double total = calculateTotal();
        strategy.pay(total);
    }

    public static class Item {
        private final String name;
        private final double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() { return price; }
        public String getName() { return name; }
    }
}

