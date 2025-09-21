package com.concurrent.test.immutable;

public final class MyImmutable {

    private final String myName;

    public MyImmutable(String myName) {
        this.myName = myName;
    }

    public String getMyName() {
        return myName;
    }
}
