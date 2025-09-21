package com.concurrent.test.thread.threadpool;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class CustomThreadPoolExecutor {

    private static final int MAX_THREADS = 10;
    private static final int MAX_WAIT_MS = 100;

    private static final Logger logger = Logger.getLogger(CustomThreadPoolExecutor.class.getName());

    private final PriorityBlockingQueue<PrioritizedTask> queue = new PriorityBlockingQueue<>();

    private final ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

    private final AtomicInteger highCount = new AtomicInteger(6);
    private final AtomicInteger mediumCount = new AtomicInteger(3);
    private final AtomicInteger lowCount = new AtomicInteger(1);

    public CustomThreadPoolExecutor() {
        for (int i = 0; i < MAX_THREADS; i++) {
            executor.submit(this::worker);
        }
    }

    public boolean submitTask(Runnable task, Priority priority) {
        try {
            return queue.offer(new PrioritizedTask(task, priority), MAX_WAIT_MS, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    private void worker() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                PrioritizedTask task = pollTask();
                if (task != null) {
                    executeWithRetry(task);
                }
            } catch (Exception e) {
                logger.severe("Worker error: " + e.getMessage());
            }
        }
    }

    private PrioritizedTask pollTask() throws InterruptedException {
        PrioritizedTask task = null;
        if (mediumCount.get() > 0) {
            task = queue.poll(MAX_WAIT_MS, TimeUnit.MILLISECONDS);
            if (task != null && task.priority == Priority.MEDIUM) {
                mediumCount.decrementAndGet();
                return task;
            }
        }
        if (highCount.get() > 0) {
            task = queue.poll(MAX_WAIT_MS, TimeUnit.MILLISECONDS);
            if (task != null && task.priority == Priority.HIGH) {
                highCount.decrementAndGet();
                return task;
            }
        }
        if (lowCount.get() > 0) {
            task = queue.poll(MAX_WAIT_MS, TimeUnit.MILLISECONDS);
            if (task != null && task.priority == Priority.LOW) {
                lowCount.decrementAndGet();
                return task;
            }
        }
        // fallback: pick any available
        return queue.poll(MAX_WAIT_MS, TimeUnit.MILLISECONDS);
    }

    private void executeWithRetry(PrioritizedTask task) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                CompletableFuture.runAsync(task.task, executor).get();
                return;
            } catch (Exception e) {
                attempts++;
                if (attempts >= 2) {
                    logger.severe("Task failed after retries: " + e.getMessage());
                }
            }
        }
    }

    public void shutdown() {
        executor.shutdownNow();
    }

    public enum Priority {
        HIGH, MEDIUM, LOW
    }

    private static class PrioritizedTask implements Comparable<PrioritizedTask> {
        private final Runnable task;
        private final Priority priority;

        public PrioritizedTask(Runnable task, Priority priority) {
            this.task = task;
            this.priority = priority;
        }

        @Override
        public int compareTo(PrioritizedTask o) {
            return o.priority.ordinal() - this.priority.ordinal();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor();

        customThreadPoolExecutor.submitTask(() -> {
            System.out.println("High priority");
        }, Priority.HIGH);


        customThreadPoolExecutor.submitTask(() -> {
            System.out.println("Low priority task");
        }, Priority.LOW);
        customThreadPoolExecutor.submitTask(() -> {
            System.out.println("Medium priority task");
        }, Priority.MEDIUM);

        customThreadPoolExecutor.pollTask();
    }


}
