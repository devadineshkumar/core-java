package com.concurrent.test.design.patterns.behavioral.template;

/**
 * Concrete implementation of a Game: Cricket.
 */
public class CricketGame extends Game {
    @Override
    protected void initialize() {
        System.out.println("CricketGame: Initializing players and pitch...");
    }

    @Override
    protected void startPlay() {
        System.out.println("CricketGame: Starting the cricket match...");
    }

    @Override
    protected void endPlay() {
        System.out.println("CricketGame: Match ended. Displaying scoreboard...");
    }
}

