package com.concurrent.test.threadcontext;

import java.util.concurrent.CompletableFuture;

public class FutureVsCompletableFuture {

    public static void main(String[] args) throws Exception {
        demonstrateFuture();
        System.out.println("\n" + "=".repeat(50) + "\n");
        demonstrateCompletableFuture();
    }

    private static void demonstrateFuture() throws Exception {
        System.out.println("=== Future Example ===");

        ThreadPoolExecutorWithContextCopying executor = new ThreadPoolExecutorWithContextCopying(
                2, 4, 60L, java.util.concurrent.TimeUnit.SECONDS,
                new java.util.concurrent.LinkedBlockingQueue<>()
        );

        // Set context in main thread
        ThreadPoolExecutorWithContextCopying.setContextValue("userId", "future-user123");
        ThreadPoolExecutorWithContextCopying.setContextValue("requestId", "future-req456");

        System.out.println("Main thread context - userId: " +
                ThreadPoolExecutorWithContextCopying.getContextValue("userId"));

        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        // Submit a task that returns a result
        java.util.concurrent.Future<String> future = executor.submit(() -> {
            String userId = (String) ThreadPoolExecutorWithContextCopying.getContextValue("userId");
            String requestId = (String) ThreadPoolExecutorWithContextCopying.getContextValue("requestId");

            // Simulate some work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            return "Result from Future - userId: " + userId + ", requestId: " + requestId;
        });

        // Blocking call to get result
        System.out.println("Future result: " + future.get());

        executor.shutdown();
    }

    private static void demonstrateCompletableFuture() {
        System.out.println("=== CompletableFuture Example ===");

        // Set context in main thread
        ThreadPoolExecutorWithContextCopying.setContextValue("userId", "cf-user789");
        ThreadPoolExecutorWithContextCopying.setContextValue("requestId", "cf-req101");

        System.out.println("Main thread context - userId: " +
                ThreadPoolExecutorWithContextCopying.getContextValue("userId"));

        // Create CompletableFuture with async execution
        java.util.concurrent.CompletableFuture<String> completableFuture =
                java.util.concurrent.CompletableFuture.supplyAsync(() -> {
                    // Note: CompletableFuture doesn't automatically inherit thread context
                    System.out.println("CompletableFuture thread context - userId: " +
                            ThreadPoolExecutorWithContextCopying.getContextValue("userId"));

                    // Simulate some work
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    return "Initial result from CompletableFuture";
                });

        // Chain operations
        java.util.concurrent.CompletableFuture<String> chainedFuture = completableFuture
                .thenApply(result -> result + " -> Transformed")
                .thenCompose(result -> java.util.concurrent.CompletableFuture.supplyAsync(() ->
                        result + " -> Composed"))
                .exceptionally(throwable -> "Error occurred: " + throwable.getMessage());

        // Non-blocking way to handle result
        chainedFuture.thenAccept(result ->
                System.out.println("CompletableFuture final result: " + result));

        // Wait for completion
        try {
            chainedFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Demonstrate combining multiple CompletableFutures
        demonstrateCombiningCompletableFutures();
    }

    private static void demonstrateCombiningCompletableFutures() {
        System.out.println("\n=== Combining CompletableFutures ===");

        java.util.concurrent.CompletableFuture<String> future1 =
                java.util.concurrent.CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return "Result1";
                });

        java.util.concurrent.CompletableFuture<String> future2 =
                java.util.concurrent.CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return "Result2";
                });

        // Combine both futures
        java.util.concurrent.CompletableFuture<String> combinedFuture =
                future1.thenCombine(future2, (result1, result2) -> result1 + " + " + result2);
        combinedFuture.thenAccept(result ->
                System.out.println("Combined result: " + result));
        // Wait for completion
        try {
            String resValue = combinedFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
