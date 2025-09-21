package com.concurrent.test.thread;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {

    private volatile Queue<String> queue = new LinkedBlockingQueue<>();


    public static void main(String[] args) {

        ProducerAndConsumer pc = new ProducerAndConsumer();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Message " + i);
                pc.queue.add(("Message " + i));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                String value = pc.queue.poll();
                try {
                    System.out.println("Taking " + value);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                String value = pc.queue.poll();
                try {
                    System.out.println("Taking " + value);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumer.start();
        consumer1.start();

        try {
            producerThread.join();
            consumer.join();
            consumer1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
