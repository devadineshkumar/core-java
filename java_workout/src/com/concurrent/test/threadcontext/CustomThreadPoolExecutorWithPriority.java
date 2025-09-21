package com.concurrent.test.threadcontext;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutorWithPriority {

    enum Priority {
        HIGH(3), MEDIUM(2), LOW(1);

        int weight;

        Priority(int weight) {
            this.weight = weight;
        }
    }

    private final BlockingQueue<String> taskQueue = new LinkedBlockingQueue<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public void submitTask(String data, Priority priority) {
        taskQueue.add(data);
    }

    public void processTasks() {
        while (true) {
            try {
                String task = taskQueue.take();

                CompletableFuture<?> s = (CompletableFuture<?>) executor.submit(() -> processTask(task));

//                s.onCompletion((v,t) -> System.out.println("Task completed: " + v));
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }

    private void processTask(String task) {
        System.out.println("Processing task: " + task);
    }

//    public static void main(String[] args) {
//        CustomThreadPoolExecutorWithPriority scheduler = new CustomThreadPoolExecutorWithPriority();
//
//        // Simulate incoming tasks
//        scheduler.submitTask(() -> System.out.println("Low priority task"), Priority.LOW);
//        scheduler.submitTask(() -> System.out.println("Medium priority task"), Priority.MEDIUM);
//        scheduler.submitTask(() -> {
//            throw new RuntimeException("Simulated failure");
//        }, Priority.HIGH);
//        scheduler.submitTask(() -> System.out.println("Another high priority task"), Priority.HIGH);
//    }


}
