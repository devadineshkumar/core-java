package com.concurrent.test.leetcode.recursion;

import java.util.List;

public class DigitToPossibleWords {

    public static void main(String[] args) {
        // Test the letterCombinations method
        String digits1 = "23";
        System.out.println("Input: " + digits1);
        System.out.println("Output: " + letterCombinations(digits1));

        String digits2 = "";
        System.out.println("Input: " + digits2);
        System.out.println("Output: " + letterCombinations(digits2));

        String digits3 = "2";
        System.out.println("Input: " + digits3);
        System.out.println("Output: " + letterCombinations(digits3));
    }

    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return new java.util.ArrayList<>();
        }

        String[] mapping = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };


        List<String> result = new java.util.ArrayList<>();

        solve(result, mapping, 0, digits, new StringBuilder());
        return result;
    }

    private static void solve(List<String> result, String[] mapping, int i, String digits, StringBuilder stringBuilder) {

        if(i >= digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        String letters = mapping[digits.charAt(i) - '0'];

        for (int j = 0; j < letters.length(); j++) {
            stringBuilder.append(letters.charAt(j));
            solve(result, mapping, i + 1, digits, stringBuilder);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
    }



}
