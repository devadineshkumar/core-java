package com.concurrent.test.design.patterns.behavioral.mediator;

/**
 * Demo for Mediator pattern (simple ChatRoom).
 */
public class MediatorDemo {
    public static void main(String[] args) {
        ChatRoom chat = new ChatRoom();

        User alice = new User("Alice", chat);
        User bob = new User("Bob", chat);
        User carol = new User("Carol", chat);

        alice.send("Bob", "Hi Bob! How are you?");
        bob.send("Alice", "I'm good Alice, thanks!");

        System.out.println("-- Broadcast from Carol --");
        carol.broadcast("Hello everyone!");
    }
}

