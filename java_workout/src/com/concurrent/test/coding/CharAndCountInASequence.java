package com.concurrent.test.coding;

public class CharAndCountInASequence {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String str = "aaabbccddddeeeeaa";

        int i = 1;
        char currentChar = str.charAt(0);
        StringBuilder output = new StringBuilder();
        int k = 1;
        int len = str.length();

        while (i < len) {

            if (str.charAt(i) == currentChar) {
                k++;
            } else {
                output.append(currentChar).append(k);
                currentChar = str.charAt(i);
                k = 1;
            }

            if (i == len - 1) {
                output.append(currentChar).append(k);
            }
            i++;
        }

        System.out.println(output);

        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");

    }

    public static void test() {
        String str = "aaabbccddddeeee";

        int i = 1;
        char currentChar = str.charAt(0);
        StringBuilder output = new StringBuilder();
        int k = 1;
        int len = str.length();
        while (i < len) {

            if (str.charAt(i) == currentChar) {
                k++;
            } else {
                output.append(currentChar).append(k);
                currentChar = str.charAt(i);
                k = 1;
            }

            if (i == len - 1) {
                output.append(currentChar).append(k);
            }
            i++;
        }

        System.out.println(output);

    }
}
