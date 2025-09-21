package com.concurrent.test.javafeatures;

public final class MyClassToImpl extends SealedCheckOnClass implements SealedCheckOnInterface {

    @Override
    public void testMethod() {
        System.out.println("Testing");
    }

    @Override
    void testClassMethod() {
        super.testClassMethod();
    }
}
