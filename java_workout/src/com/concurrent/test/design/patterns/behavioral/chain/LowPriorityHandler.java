package com.concurrent.test.design.patterns.behavioral.chain;

/**
 * Handles low priority requests (priority <= 3)
 */
public class LowPriorityHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Request request) {
        if (request.getPriority() <= 3) {
            System.out.println("LowPriorityHandler handled request: " + request.getMessage());
        } else if (next != null) {
            next.handle(request);
        } else {
            System.out.println("LowPriorityHandler: no handler available for request: " + request.getMessage());
        }
    }
}

