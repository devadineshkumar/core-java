package com.concurrent.test.design.patterns.behavioral.state;

/**
 * Demo runner for State pattern (Traffic Light).
 */
public class StateDemo {
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext(new RedState());

        // simulate a few steps of the traffic light
        for (int i = 0; i < 4; i++) {
            context.request();
            System.out.println("--- step " + (i + 1) + " complete ---");
        }
    }
}

