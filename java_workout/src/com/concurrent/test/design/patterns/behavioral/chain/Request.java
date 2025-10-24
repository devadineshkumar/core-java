package com.concurrent.test.design.patterns.behavioral.chain;

/**
 * Simple Request class used in the chain example. Priority from 1 (low) to 10 (high).
 */
public class Request {
    private final int priority;
    private final String message;

    public Request(int priority, String message) {
        this.priority = priority;
        this.message = message;
    }

    public int getPriority() {
        return priority;
    }

    public String getMessage() {
        return message;
    }
}

