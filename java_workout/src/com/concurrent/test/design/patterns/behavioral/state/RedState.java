package com.concurrent.test.design.patterns.behavioral.state;

/**
 * Red state: stops traffic, then transitions to Green.
 */
public class RedState implements State {
    @Override
    public void handle(TrafficLightContext context) {
        System.out.println("Traffic Light: RED - STOP");
        // transition to green after red
        context.setState(new GreenState());
        System.out.println("Transitioning from RED to GREEN");
    }
}

