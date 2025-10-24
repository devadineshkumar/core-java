package com.concurrent.test.design.patterns.behavioral.observer;

/**
 * Concrete Observer: registers itself with a Subject and reacts when notified.
 * In this example the observer simply prints the new state and optionally performs a simple action
 * when a threshold is reached.
 */
public class ConcreteObserver implements Observer {
    private final String name;
    private final Subject subject;
    private final int alertThreshold;

    public ConcreteObserver(String name, Subject subject, int alertThreshold) {
        this.name = name;
        this.subject = subject;
        this.alertThreshold = alertThreshold;
        // Register with subject on creation
        subject.registerObserver(this);
    }

    @Override
    public void update(int newState) {
        System.out.println("[" + name + "] Received update: newState=" + newState);
        if (newState >= alertThreshold) {
            System.out.println("[" + name + "] ALERT: state (" + newState + ") reached threshold " + alertThreshold);
        }
    }

    public void unsubscribe() {
        subject.unregisterObserver(this);
        System.out.println("[" + name + "] Unsubscribed from subject");
    }
}

