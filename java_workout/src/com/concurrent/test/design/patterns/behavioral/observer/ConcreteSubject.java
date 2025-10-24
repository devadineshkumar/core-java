package com.concurrent.test.design.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject: maintains a list of observers and notifies them when its state changes.
 * In this simple example the state is an integer. Observers react to the new state when notified.
 */
public class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int state;

    @Override
    public synchronized void registerObserver(Observer o) {
        if (o == null) return;
        observers.add(o);
    }

    @Override
    public synchronized void unregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        // Make a copy of list to avoid ConcurrentModificationException if observers change during notification
        List<Observer> copy;
        synchronized (this) {
            copy = new ArrayList<>(observers);
        }
        for (Observer o : copy) {
            o.update(state);
        }
    }

    @Override
    public synchronized int getState() {
        return state;
    }

    @Override
    public synchronized void setState(int state) {
        this.state = state;
        notifyObservers();
    }
}

