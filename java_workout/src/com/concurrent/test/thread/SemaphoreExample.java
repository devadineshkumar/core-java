package com.concurrent.test.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // Only 2 threads can access at a time

        for (int i = 1; i <= 5; i++) {
            int id = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + id + " waiting for permit...");
                    semaphore.acquire();
                    System.out.println("Thread " + id + " acquired permit.");
                    Thread.sleep(4000);
                    System.out.println("Thread " + id + " releasing permit.");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
