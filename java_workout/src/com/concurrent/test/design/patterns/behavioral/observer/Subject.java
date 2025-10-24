package com.concurrent.test.design.patterns.behavioral.observer;

/**
 * Subject interface: allows observers to register/unregister and notifies them of state changes.
 */
public interface Subject {
    void registerObserver(Observer o);
    void unregisterObserver(Observer o);
    void notifyObservers();
    int getState();
    void setState(int state);
}

