package com.concurrent.test.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();
    private final ReentrantLock lock1 = new ReentrantLock();
    Condition s = lock.newCondition();


    public void printNumbers(String threadName) {
        lock.lock(); // Acquire the lock
        try {
            System.out.println(threadName + " acquired the lock.");
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " prints: " + i);
                Thread.sleep(100); // Simulate some work
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        } finally {
            System.out.println(threadName + " releasing the lock.");
            lock.unlock(); // Always release the lock in finally block
        }

        lock1.lock(); // Acquire the lock
        try {
            System.out.println(threadName + " acquired the lock.");
            for (int i = 1; i <= 2; i++) {
                System.out.println(threadName + " prints: " + i);
                Thread.sleep(10000); // Simulate some work
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        } finally {
            System.out.println(threadName + " releasing the lock.");
            lock1.unlock(); // Always release the lock in finally block
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            resource.printNumbers(threadName);
        };

        Runnable task1 = () -> {
            String threadName = Thread.currentThread().getName();
            resource.printNumbers(threadName);
        };

        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task1, "Thread-B");
        t2.start();
        t1.start();

    }
}

