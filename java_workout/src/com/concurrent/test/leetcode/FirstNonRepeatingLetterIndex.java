package com.concurrent.test.leetcode;

import java.util.HashMap;
import java.util.stream.IntStream;

public class FirstNonRepeatingLetterIndex {

    public static void main(String[] args) {
        System.out.println(firstUniqueChar1("ajaebcbcdd" ));
    }

    public static int firstUniqueChar1(String s) {

        HashMap<Character, Integer> charCount = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char charTocheck = s.charAt(i);
            charCount.put(charTocheck, charCount.getOrDefault(charTocheck, 0) + 1);
        }


//        for (int i = 0; i < s.length(); i++) {
//            if (charCount.get(s.charAt(i)) == 1) {
//                return i;
//            }
//        }

        // Option 1: Using IntStream with filter and findFirst
        return IntStream.range(0, s.length())
                .filter(i -> charCount.get(s.charAt(i)) == 1)
                .findFirst()
                .orElse(-1);

//        return -1;

    }

    public static int firstUniqueChar(String s) {

        int[] charCount = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Find first character with count 1
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
