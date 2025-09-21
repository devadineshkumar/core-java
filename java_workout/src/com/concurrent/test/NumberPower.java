package com.concurrent.test;

public class NumberPower {

    public static void main(String[] args) {

        System.out.println(findPower(2, 2));
    }

    private static int findPower(int n, int power) {

        if (power <= 0) {
            return 0;
        }

        if (power > 1) {
            return n * findPower(n, power - 1);
        } else {
            return n;
        }

    }


}
