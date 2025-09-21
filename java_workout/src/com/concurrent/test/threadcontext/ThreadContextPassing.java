package com.concurrent.test.threadcontext;

public class ThreadContextPassing {

    // Demonstrates passing thread context between threads
    private static final ThreadLocal<String> threadContext = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        // Set context in main thread
        threadContext.set("Main Thread Context");
        System.out.println("Main thread context: " + threadContext.get());

        // Create and start a new thread
        Thread workerThread = new Thread(() -> {
            // Context is not automatically passed to new thread
            System.out.println("Worker thread context (before set): " + threadContext.get());

            // Set context in worker thread
            threadContext.set("Worker Thread Context");
            System.out.println("Worker thread context (after set): " + threadContext.get());
        });

        workerThread.start();
        workerThread.join();

        // Main thread context remains unchanged
        System.out.println("Main thread context (after worker): " + threadContext.get());

        // Demonstrate context passing using InheritableThreadLocal
        demonstrateInheritableThreadLocal();
        System.out.println("Main thread context (after child): " + threadContext.get());
    }

    private static void demonstrateInheritableThreadLocal() throws InterruptedException {
        InheritableThreadLocal<String> inheritableContext = new InheritableThreadLocal<>();

        // Set context in main thread
        inheritableContext.set("Child Context");
        System.out.println("\nMain thread inheritable context: " + inheritableContext.get());

        // Create thread that inherits context
        Thread childThread = new Thread(() -> {
            // Context is automatically inherited
            System.out.println("Child thread inherited context: " + inheritableContext.get());
            System.out.println("Child thread inherited context: " + threadContext.get());
        });
        childThread.start();
    }
}
