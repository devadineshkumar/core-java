package com.concurrent.test.design.patterns.behavioral.chain;

/**
 * Handler interface for Chain of Responsibility pattern.
 */
public interface Handler {
    void setNext(Handler next);
    void handle(Request request);
}

