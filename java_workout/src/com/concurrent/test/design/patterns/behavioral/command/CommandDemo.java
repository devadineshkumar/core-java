package com.concurrent.test.design.patterns.behavioral.command;

/**
 * Demo for the Command pattern.
 */
public class CommandDemo {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command turnOn = new TurnOnCommand(receiver);
        Command turnOff = new TurnOffCommand(receiver);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(turnOn);
        remote.pressButton();

        remote.setCommand(turnOff);
        remote.pressButton();
    }
}

