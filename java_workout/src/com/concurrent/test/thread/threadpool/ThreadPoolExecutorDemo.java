package com.concurrent.test.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws InterruptedException {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5, // corePoolSize
                10, // maximumPoolSize
                0L, // keepAliveTime
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), // workQueue
                new ThreadPoolExecutor.AbortPolicy() // default rejection policy
        );

        // Optional: Custom rejection handler to log rejected tasks
        executor.setRejectedExecutionHandler((r, e) -> {
            System.out.println("Task rejected: " + r.toString());
        });

        // Submit 15 tasks
        for (int i = 1; i <= 15; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing task " + taskId);
                try {
                    Thread.sleep(2000); // Simulate task duration
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        System.out.println("All tasks submitted.");

    }
}
