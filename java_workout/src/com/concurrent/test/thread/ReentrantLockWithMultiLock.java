package com.concurrent.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockWithMultiLock {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    public void readData() {
        readLock.lock();
        try {
            System.out.println("Reading Data" + Thread.currentThread().getName());
        } finally {
            readLock.unlock();
        }
    }

    public void writeData() {
        writeLock.lock();
        try {
            System.out.println("Writing Data" + Thread.currentThread().getName());
        } finally {
            writeLock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        ReentrantLockWithMultiLock multiLock = new ReentrantLockWithMultiLock();

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            CompletableFuture<Void> writeThread = CompletableFuture.runAsync(() -> {
                if (finalI % 2 == 0) {
                    multiLock.writeData();
                } else {
                    multiLock.readData();
                }
            }).thenAccept((voidd ) -> System.out.println("Completed"));
        }

        Thread.currentThread().join(20000);
    }

}
