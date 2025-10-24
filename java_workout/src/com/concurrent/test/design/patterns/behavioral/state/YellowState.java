package com.concurrent.test.design.patterns.behavioral.state;

/**
 * Yellow state: caution, then transitions to Red.
 */
public class YellowState implements State {
    @Override
    public void handle(TrafficLightContext context) {
        System.out.println("Traffic Light: YELLOW - CAUTION");
        // transition to red after yellow
        context.setState(new RedState());
        System.out.println("Transitioning from YELLOW to RED");
    }
}

