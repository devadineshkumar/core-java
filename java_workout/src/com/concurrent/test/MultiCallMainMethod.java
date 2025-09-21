package com.concurrent.test;

public class MultiCallMainMethod {

    public static void main(String[] args) {
        ServiceImpl service = new ServiceImpl();

        Thread thread = new Thread(() -> {
            service.publish(1);
        });

        Thread thread1 = new Thread(() -> {
            service.publish(2);
        });

        Thread thread2 = new Thread(() -> {
            service.publish(3);
        });

        thread.start();
        thread1.start();
        thread2.start();

    }
}
