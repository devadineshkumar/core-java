package com.concurrent.test.design.patterns.behavioral.observer;

/**
 * Observer interface: defines the update contract for observers.
 */
public interface Observer {
    /**
     * Called by Subject when its state changes.
     * @param newState the new state value from the subject
     */
    void update(int newState);
}

