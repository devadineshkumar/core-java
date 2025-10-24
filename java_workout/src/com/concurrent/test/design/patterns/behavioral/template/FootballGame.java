package com.concurrent.test.design.patterns.behavioral.template;

/**
 * Concrete implementation of a Game: Football.
 */
public class FootballGame extends Game {
    @Override
    protected void initialize() {
        System.out.println("FootballGame: Initializing teams and stadium...");
    }

    @Override
    protected void startPlay() {
        System.out.println("FootballGame: Kick-off! The football match is on...");
    }

    @Override
    protected void endPlay() {
        System.out.println("FootballGame: Match ended. Announcing winner...");
    }
}

