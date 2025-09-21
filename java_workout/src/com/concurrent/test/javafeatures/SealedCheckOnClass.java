package com.concurrent.test.javafeatures;

public sealed class SealedCheckOnClass permits MyClassToImpl {

    void testClassMethod() {
        System.out.println(" Test ..");
    }
}
