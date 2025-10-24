package com.concurrent.test.design.patterns.behavioral.mediator;

/**
 * Mediator interface: defines operations for sending messages between colleagues.
 */
public interface Mediator {
    void sendMessage(String from, String to, String message);
    void broadcast(String from, String message);
}

