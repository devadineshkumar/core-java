package com.concurrent.test.thread.threadpool;

public class ThreadPoolTypes {

    public static void main(String[] args) {

        java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(5);
        System.out.println("Starting the submission..");
        for (int i = 1; i <= 20; i++) {
            ThreadOperation op = new ThreadOperation(i);
            executor.submit(op::runTask);
        }
        System.out.println("Stopping the submission...");
        executor.shutdown();


    }

}

class ThreadOperation {

    private int number;

    public ThreadOperation(int number) {
        this.number = number;
    }

    public void runTask() {
        System.out.println("Printing thread");
        try {
            Thread.sleep(500);
            System.out.println("running thread "+ this.number);
        } catch (InterruptedException e) {
            System.out.println("Thread got interrupted " + e);
        }
    }

}
