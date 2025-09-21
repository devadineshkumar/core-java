package com.concurrent.test.leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        int number = -1231;
        int number1 = 1534236469;
        int number2 = 1001;
        System.out.println("Reverse of a number " + number + " is " + reverse(number));
        System.out.println("Reverse of a number " + number1 + " is " + reverse(number1));
        System.out.println("Reverse of a number " + number2 + " is " + reverse(number2));
    }

    public static int reverse(int x) {
        if (x == 0) return 0;
        long sign = x / Math.abs(x);
        x = Math.abs(x);
        long reverse = 0;
        while (x > 0) {
            reverse = (x % 10) + (reverse * 10);
            x /= 10;
        }
        return reverse > Integer.MAX_VALUE ? 0 : Math.toIntExact(reverse / sign);
    }
}
