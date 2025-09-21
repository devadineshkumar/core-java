package com.concurrent.test.thread;

public class ThreadPrinter {
    private static final int THREAD_COUNT = 5;
    private static final Object lock = new Object();
    private static int turn = 0;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            int threadId = i;
            new Thread(() -> {
                for (int j = 0; j < 5; j++) { // Each thread prints 5 times
                    synchronized (lock) {
                        while (turn % THREAD_COUNT != threadId) {
                            try {
                                System.out.println("Thread Waiting is " + threadId + " and Thread Print Turn is "+turn);
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        System.out.println("Thread " + threadId + " prints: " + j);
                        turn++;
                        lock.notifyAll();
                    }
                }
            }).start();
        }
    }
}
