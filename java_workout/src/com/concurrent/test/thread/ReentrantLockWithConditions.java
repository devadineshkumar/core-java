package com.concurrent.test.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithConditions {

    static class SharedBuffer {
        private final Queue<Integer> buffer = new LinkedList<>();
        private final int capacity = 5;

        private final ReentrantLock lock = new ReentrantLock();

        private final Condition notFull = lock.newCondition();
        private final Condition notEmpty = lock.newCondition();

        public void produce(int value) throws InterruptedException {
            lock.lock();
            try {
                while (buffer.size() == capacity) {
                    System.out.println("Buffer full, producer waiting...");
                    notFull.await();
                }
                buffer.add(value);
                System.out.println("Produced: " + value);
                notEmpty.signal(); // Signal consumer
            } finally {
                lock.unlock();
            }
        }

        public int consume() throws InterruptedException {
            lock.lock();
            try {
                while (buffer.isEmpty()) {
                    System.out.println("Buffer empty, consumer waiting...");
                    notEmpty.await();
                }
                int value = buffer.poll();
                System.out.println("Consumed: " + value);
                notFull.signal(); // Signal producer
                return value;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        // Producer thread
        Thread producer = new Thread(() -> {
            int value = 0;
            try {
                while (true) {
                    buffer.produce(value++);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    buffer.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
