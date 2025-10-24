package com.concurrent.test.design.patterns.behavioral.command;

/**
 * Invoker: holds a command and can execute it.
 */
public class RemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void pressButton() {
        if (slot != null) {
            slot.execute();
        } else {
            System.out.println("No command assigned to this slot");
        }
    }
}

