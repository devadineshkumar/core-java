package com.concurrent.test.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) {
        int threadCount = 3;
        CountDownLatch latch = new CountDownLatch(3);

        // Create and start worker threads
        for (int i = 1; i <= threadCount; i++) {
            Thread worker = new Thread(new Worker(latch, i));
            worker.start();
        }

        System.out.println("Main thread is waiting for workers to finish...");

        try {
            latch.await(); // Wait until all threads have called countDown()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All workers finished. Main thread continues.");
    }

    static class Worker implements Runnable {
        private final CountDownLatch latch;
        private final int workerId;

        Worker(CountDownLatch latch, int workerId) {
            this.latch = latch;
            this.workerId = workerId;
        }

        @Override
        public void run() {
            System.out.println("Worker " + workerId + " is doing work...");
            try {
                Thread.sleep(3000 * workerId); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker " + workerId + " finished.");
            latch.countDown(); // Signal that this thread is done
        }
    }
}
