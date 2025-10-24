package com.concurrent.test.design.patterns.behavioral.command;

/**
 * Concrete Command to turn off the receiver.
 */
public class TurnOffCommand implements Command {
    private final Receiver receiver;

    public TurnOffCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOff();
    }
}

