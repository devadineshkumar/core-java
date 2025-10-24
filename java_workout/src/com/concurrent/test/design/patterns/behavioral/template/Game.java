package com.concurrent.test.design.patterns.behavioral.template;

/**
 * Template Method: abstract game defines skeleton of algorithm.
 */
public abstract class Game {
    // template method
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    protected abstract void initialize();
    protected abstract void startPlay();
    protected abstract void endPlay();
}

