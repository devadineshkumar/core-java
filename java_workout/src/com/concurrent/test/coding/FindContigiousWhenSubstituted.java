package com.concurrent.test.coding;

public class FindContigiousWhenSubstituted {

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0};
        int sub = 2;

        int maxLen = 0;
        int right = 0;
        int zeroCount = 0;

        for (int left = 0; left < array.length; left++) {

            if (array[left] == 0) {
                zeroCount++;
            }

            while (zeroCount > sub) {
                if (array[right] == 0) {
                    zeroCount--;
                }
                right++;
            }
            maxLen = Math.max(maxLen, left - right + 1);
        }

        System.out.println("Longest contiguous 1s after substituting at most " + sub + " zeros: " + maxLen);
    }


}
