package com.concurrent.test.design.patterns.creational;

public class SingletonPattern {
    // Eager initialization - thread-safe but creates instance even if not used
    private static final SingletonPattern eagerInstance = new SingletonPattern();

    // Lazy initialization with double-checked locking - thread-safe and efficient
    private static volatile SingletonPattern lazyInstance;

    // Private constructor to prevent instantiation
    private SingletonPattern() {
        // Prevent reflection-based instantiation
        if (eagerInstance != null) {
            throw new RuntimeException("Use getInstance() method to create instance");
        }
    }

    // Eager initialization getter
    public static SingletonPattern getEagerInstance() {
        return eagerInstance;
    }

    // Lazy initialization with double-checked locking
    public static SingletonPattern getLazyInstance() {
        if (lazyInstance == null) {
            synchronized (SingletonPattern.class) {
                if (lazyInstance == null) {
                    lazyInstance = new SingletonPattern();
                }
            }
        }
        return lazyInstance;
    }

    // Thread-safe enum-based singleton (recommended approach)
    public enum SingletonEnum {
        INSTANCE;

        public void doSomething() {
            System.out.println("Enum singleton method called");
        }
    }

    // Bill Pugh Singleton Pattern using inner static helper class
    private static class SingletonHelper {
        private static final SingletonPattern INSTANCE = new SingletonPattern();
    }

    public static SingletonPattern getBillPughInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Example method to demonstrate singleton functionality
    public void performOperation() {
        System.out.println("Singleton operation performed by: " + this.hashCode());
    }

    // Prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of singleton is not allowed");
    }
}
