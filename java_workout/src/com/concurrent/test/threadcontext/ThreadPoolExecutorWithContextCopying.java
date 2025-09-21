package com.concurrent.test.threadcontext;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * A ThreadPoolExecutor that copies thread context from the submitting thread
 * to the executing thread using ThreadLocal variables.
 */
public class ThreadPoolExecutorWithContextCopying extends ThreadPoolExecutor {

    private static final ThreadLocal<Map<String, Object>> threadContext = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    public ThreadPoolExecutorWithContextCopying(int corePoolSize, int maximumPoolSize,
                                                long keepAliveTime, TimeUnit unit,
                                                BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        // Capture context from submitting thread
        Map<String, Object> contextCopy = new HashMap<>(threadContext.get());

        // Wrap the command to restore context in executing thread
        Runnable wrappedCommand = () -> {
            Map<String, Object> originalContext = threadContext.get();
            try {
                // Set the copied context
                threadContext.set(contextCopy);
                command.run();
            } finally {
                // Restore original context
                threadContext.set(originalContext);
            }
        };

        super.execute(wrappedCommand);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        // Capture context from submitting thread
        Map<String, Object> contextCopy = new HashMap<>(threadContext.get());

        // Wrap the task to restore context in executing thread
        Callable<T> wrappedTask = () -> {
            Map<String, Object> originalContext = threadContext.get();
            try {
                // Set the copied context
                threadContext.set(contextCopy);
                return task.call();
            } finally {
                // Restore original context
                threadContext.set(originalContext);
            }
        };

        return super.submit(wrappedTask);
    }

    // Utility methods for managing thread context
    public static void setContextValue(String key, Object value) {
        threadContext.get().put(key, value);
    }

    public static Object getContextValue(String key) {
        return threadContext.get().get(key);
    }

    public static void clearContext() {
        threadContext.get().clear();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutorWithContextCopying executor = new ThreadPoolExecutorWithContextCopying(
                2, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>()
        );

        // Set context in main thread
        setContextValue("userId", "user123");
        setContextValue("requestId", "req456");

        System.out.println("Main thread context - userId: " + getContextValue("userId"));
        System.out.println("Main thread context - requestId: " + getContextValue("requestId"));

        // Submit tasks that should inherit the context
        for (int i = 0; i < 3; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " - userId: " + getContextValue("userId"));
                System.out.println("Task " + taskId + " - requestId: " + getContextValue("requestId"));
            });
        }

        Thread.sleep(1000);
        executor.shutdown();
    }
}