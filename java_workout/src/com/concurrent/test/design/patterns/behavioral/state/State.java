package com.concurrent.test.design.patterns.behavioral.state;

/**
 * State interface for Traffic Light example.
 */
public interface State {
    void handle(TrafficLightContext context);
}

