package com.concurrent.test.leetcode;

public class IsSubsequence {

    public static void main(String[] args) {

        String s = "abc";
        String t = "aebdc";
        System.out.println("Is '" + s + "' a subsequence of '" + t + "'? " + isSubsequence(s, t));

        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Is '" + s2 + "' a subsequence of '" + t2 + "'? " + isSubsequence(s2, t2));

    }

    public static boolean isSubsequence(String s, String t) {

        int i = 0;
        int sub = 0;

        while (i < t.length()) {

            if(t.charAt(i) == s.charAt(sub)) {
                sub++;
            }
            i++;
        }

        return sub == s.length();

    }
}
