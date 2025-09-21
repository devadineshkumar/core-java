package com.concurrent.test.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All parties reached the barrier. Proceeding...");
        });

        for (int i = 1; i <= 3; i++) {
            int id = i;
            new Thread(() -> {
                System.out.println("Thread " + id + " is doing work...");
                try {
                    Thread.sleep(1000 * id);
                    System.out.println("Thread " + id + " waiting at barrier.");
                    barrier.await();
                    System.out.println("Thread " + id + " passed the barrier.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
