package com.concurrent.test.design.patterns.behavioral.mediator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Concrete Mediator: simple chat room that routes messages between users.
 */
public class ChatRoom implements Mediator {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public void registerUser(User user) {
        if (user == null) return;
        users.put(user.getName(), user);
    }

    @Override
    public void sendMessage(String from, String to, String message) {
        User recipient = users.get(to);
        if (recipient != null) {
            recipient.receive(from, message);
        } else {
            System.out.println("[ChatRoom] User '" + to + "' not found. Message from '" + from + "' not delivered.");
        }
    }

    @Override
    public void broadcast(String from, String message) {
        users.values().stream()
                .filter(u -> !u.getName().equals(from))
                .forEach(u -> u.receive(from, message));
    }
}

