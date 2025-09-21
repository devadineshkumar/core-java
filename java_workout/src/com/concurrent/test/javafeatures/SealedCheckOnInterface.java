package com.concurrent.test.javafeatures;

public sealed interface SealedCheckOnInterface permits MyClassToImpl {

    void testMethod();
}
