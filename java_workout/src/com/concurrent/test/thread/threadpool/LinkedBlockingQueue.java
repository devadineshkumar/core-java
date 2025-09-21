package com.concurrent.test.thread.threadpool;

import java.util.concurrent.BlockingQueue;

public class LinkedBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new java.util.concurrent.LinkedBlockingQueue<>(5); // bounded queue

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));
        Thread consumerThread1 = new Thread(new Consumer(queue));
        Thread consumerThread2 = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}


class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (true) {
                System.out.println("Produced: " + value);
                queue.put(value++); // blocks if queue is full
                Thread.sleep(500);  // simulate time to produce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int value = queue.take(); // blocks if queue is empty
                System.out.println("Consumed: " + value);
                Thread.sleep(1000); // simulate time to consume
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

