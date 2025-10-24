package com.concurrent.test.design.patterns.behavioral.state;

/**
 * Context for the Traffic Light state machine.
 */
public class TrafficLightContext {
    private State state;

    public TrafficLightContext(State initial) {
        this.state = initial;
    }

    public synchronized void setState(State state) {
        this.state = state;
    }

    public synchronized State getState() {
        return state;
    }

    public void request() {
        state.handle(this);
    }
}

