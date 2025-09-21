package com.concurrent.test.thread;

// Java Program to demonstrate synchronization block in Java

class Counter {
    private int c = 0; // Shared variable

    // Method with synchronization block
    public void inc() {
        synchronized (this) { // Synchronize only this block
            System.out.println("Counting the increment from Thread " + Thread.currentThread().getName());
            c++;
        }
    }

    // Method to get counter value
    public int get() {
        return c;
    }
}

public class SynchronisedBlock {
    public static void main(String[] args) {
        Counter cnt = new Counter(); // Shared resource

        // Thread 1 to increment counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cnt.inc();
            }
            System.out.println("T1 completed");
        });

        // Thread 2 to increment counter
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                cnt.inc();
            }
            try {

                System.out.println("T2 completed");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t2.join();
            t1.join();
            System.out.println("ddd");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print final counter value
        System.out.println("Counter: " + cnt.get());
    }
}
