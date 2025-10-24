package com.concurrent.test.design.patterns.behavioral.chain;

/**
 * Demo for Chain of Responsibility pattern.
 */
public class ChainDemo {
    public static void main(String[] args) {
        Handler low = new LowPriorityHandler();
        Handler med = new MediumPriorityHandler();
        Handler high = new HighPriorityHandler();

        low.setNext(med);
        med.setNext(high);

        Request r1 = new Request(2, "Low priority task");
        Request r2 = new Request(5, "Medium priority task");
        Request r3 = new Request(9, "High priority task");

        low.handle(r1);
        low.handle(r2);
        low.handle(r3);
    }
}

