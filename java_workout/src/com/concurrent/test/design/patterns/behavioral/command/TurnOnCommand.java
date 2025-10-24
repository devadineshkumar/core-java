package com.concurrent.test.design.patterns.behavioral.command;

/**
 * Concrete Command to turn on the receiver.
 */
public class TurnOnCommand implements Command {
    private final Receiver receiver;

    public TurnOnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOn();
    }
}

