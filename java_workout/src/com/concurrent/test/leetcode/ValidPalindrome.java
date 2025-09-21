package com.concurrent.test.leetcode;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "atrta";
        String string = "A man, a plan, a canal: Panama";
        String string1 = "0p0";
//        System.out.println("Is ValidPalindrome " + isPalindrome(s));
        long time = System.currentTimeMillis();
        System.out.println("Is ValidPalindrome " + isPalindrome(string1));
        System.out.println("Time Taken " + (System.currentTimeMillis() - time));
        System.out.println("----");
        time = System.currentTimeMillis();
        System.out.println("Is ValidPalindrome " + isPalindrome(string1));
        System.out.println("Time Taken 2 " + (System.currentTimeMillis() - time));
    }

    public static boolean isPalindrome(String s) {

        int length = s.length();
        int l = 0;
        int r = length - 1;

        while (l < r) {
            char lChar = s.charAt(l);
            char rChar = s.charAt(r);

            if (!isAlphaNumeric(lChar)) {
                l++;
            } else if (!isAlphaNumeric(rChar)) {
                r--;
            } else {
                if (toLowerCase(lChar) != toLowerCase(rChar)) {
                    return false;
                }
                l++;
                r--;
            }
        }

        return true;
    }

    public static boolean isPalindrome1(String s) {
        if (s == null || s.length() <= 1) return true;

        int length = s.length();
        int l = 0;
        int r = length - 1;

        while (l < r) {
            char leftChar = s.charAt(l);
            char rightChar = s.charAt(r);

            if (!isAlphaNumeric(leftChar)) {
                l++;
            } else if (!isAlphaNumeric(rightChar)) {
                r--;
            } else {
                if (toLowerCase(leftChar) != toLowerCase(rightChar)) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private static char toLowerCase(char c) {
        return (c >= 'A' && c <= 'Z') ? (char) (c + 32) : c;
    }

}
