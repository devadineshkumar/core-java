package com.concurrent.test.design.patterns.behavioral.command;

/**
 * Receiver: knows how to perform the actual actions.
 */
public class Receiver {
    public void turnOn() {
        System.out.println("Receiver: Light is ON");
    }

    public void turnOff() {
        System.out.println("Receiver: Light is OFF");
    }
}

