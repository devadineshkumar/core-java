package com.concurrent.test.design.patterns.behavioral.observer;

/**
 * Demo for the Observer behavioral pattern.
 *
 * This demo shows:
 * - Creating a subject and multiple observers
 * - Observers registering with the subject (done in observer constructor)
 * - Subject changing its internal state and notifying observers
 * - An observer unsubscribing and no longer receiving updates
 */
public class ObserverDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcreteSubject subject = new ConcreteSubject();

        // Create observers with different alert thresholds
        ConcreteObserver obs1 = new ConcreteObserver("Observer-1", subject, 5);
        ConcreteObserver obs2 = new ConcreteObserver("Observer-2", subject, 8);

        System.out.println("--- Setting state to 3 ---");
        subject.setState(3);

        System.out.println("--- Setting state to 6 ---");
        subject.setState(6);

        System.out.println("--- Unsubscribe Observer-1 ---");
        obs1.unsubscribe();

        System.out.println("--- Setting state to 9 ---");
        subject.setState(9);

        System.out.println("Demo finished.");
    }
}

