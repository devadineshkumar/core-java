package com.concurrent.test.design.patterns.behavioral.template;

/**
 * Demo for Template Method pattern.
 */
public class TemplateDemo {
    public static void main(String[] args) {
        System.out.println("--- Playing Cricket Game ---");
        Game cricket = new CricketGame();
        cricket.play();

        System.out.println("\n--- Playing Football Game ---");
        Game football = new FootballGame();
        football.play();

        System.out.println("Template Demo finished.");
    }
}

