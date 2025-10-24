package com.concurrent.test.design.patterns.behavioral.state;

/**
 * Green state: allows traffic, then transitions to Yellow.
 */
public class GreenState implements State {
    @Override
    public void handle(TrafficLightContext context) {
        System.out.println("Traffic Light: GREEN - GO");
        // transition to yellow after green
        context.setState(new YellowState());
        System.out.println("Transitioning from GREEN to YELLOW");
    }
}

