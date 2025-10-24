package com.concurrent.test.design.patterns.behavioral.chain;

/**
 * Handles medium priority requests (4 <= priority <= 7)
 */
public class MediumPriorityHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Request request) {
        if (request.getPriority() >= 4 && request.getPriority() <= 7) {
            System.out.println("MediumPriorityHandler handled request: " + request.getMessage());
        } else if (next != null) {
            next.handle(request);
        } else {
            System.out.println("MediumPriorityHandler: no handler available for request: " + request.getMessage());
        }
    }
}

