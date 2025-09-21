package com.concurrent.test;


public class ServiceImpl {

    public void publish(int number) {
        try {
            System.out.println("Waiting for thread " + number);
            Thread.sleep(1000);
            System.out.println("Ending for thread " + number);
        } catch (Exception e) {
            System.out.println("exception " + e);
        }
    }
}
