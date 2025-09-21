package com.concurrent.test.collections;

import java.util.Collections;

public class HashMapManualThreadSafe {

    public static void main(String[] args) {
        // Create a HashMap and make it thread-safe using Collections.synchronizedMap()
        java.util.Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new java.util.HashMap<>());

        // Create multiple threads to test thread safety
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedMap.put("key" + i, i);
            }
            System.out.println("Thread 1 completed adding elements");
        };

        Runnable task2 = () -> {
            for (int i = 1000; i < 2000; i++) {
                synchronizedMap.put("key" + i, i);
            }
            System.out.println("Thread 2 completed adding elements");
        };

        Runnable task3 = () -> {
            // Synchronized iteration is required for thread safety
            synchronized (synchronizedMap) {
                for (java.util.Map.Entry<String, Integer> entry : synchronizedMap.entrySet()) {
                    System.out.println("Reading: " + entry.getKey() + " = " + entry.getValue());
                    if (synchronizedMap.size() > 10) break; // Limit output
                }
            }
        };

        // Start threads
        Thread t1 = new Thread(task1, "Writer-1");
        Thread t2 = new Thread(task2, "Writer-2");
        Thread t3 = new Thread(task3, "Reader");

        t1.start();
        t2.start();

        // Wait a bit before starting reader
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        t3.start();

        // Wait for all threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}


