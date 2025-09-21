package com.concurrent.test.leetcode.most100;

public class ReverseString {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseString(s.toCharArray()));
    }

    private static String reverseString(char[] charArray) {

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {

            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;


        }

        return String.valueOf(charArray);
    }
}
