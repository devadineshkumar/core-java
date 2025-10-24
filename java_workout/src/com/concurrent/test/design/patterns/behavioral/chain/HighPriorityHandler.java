package com.concurrent.test.design.patterns.behavioral.chain;

/**
 * Handles high priority requests (priority >= 8)
 */
public class HighPriorityHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Request request) {
        if (request.getPriority() >= 8) {
            System.out.println("HighPriorityHandler handled request: " + request.getMessage());
        } else if (next != null) {
            next.handle(request);
        } else {
            System.out.println("HighPriorityHandler: no handler available for request: " + request.getMessage());
        }
    }
}

