package com.concurrent.test.design.patterns.behavioral.mediator;

/**
 * Colleague in the mediator pattern. Users send messages via the mediator.
 */
public class User {
    private final String name;
    private final Mediator mediator;

    public User(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
        if (mediator instanceof ChatRoom) {
            ((ChatRoom) mediator).registerUser(this);
        }
    }

    public String getName() {
        return name;
    }

    public void send(String to, String message) {
        mediator.sendMessage(this.name, to, message);
    }

    public void broadcast(String message) {
        mediator.broadcast(this.name, message);
    }

    public void receive(String from, String message) {
        System.out.println("[" + name + "] Received from " + from + ": " + message);
    }
}

