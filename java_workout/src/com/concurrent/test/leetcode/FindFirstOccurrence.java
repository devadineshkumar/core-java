package com.concurrent.test.leetcode;

public class FindFirstOccurrence {

    public static void main(String[] args) {

        String haystack = "youAre";
        String needle = "you";
        int expectedValue = haystack.indexOf(needle);
        System.out.println("Expected value " + expectedValue);
        System.out.println("Computed Logic " + strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {

        int i = 0;
        int start = 0;

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(start)) {

                while ((i + start) < haystack.length() && start < needle.length() && haystack.charAt(i + start) == needle.charAt(start)) {
                    start++;
                }

                if (start == needle.length()) {
                    return i;
                } else {
                    start = 0;
                }
            }

            i++;
        }
        return -1;
    }

    /**
     * Best solution
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr1(String haystack, String needle) {
        for (int i = 0, j = needle.length(); j <= haystack.length(); i++, j++) {
            if (haystack.substring(i, j).equals(needle)) {
                return i;
            }
        }
        return -1;

    }
}
