package com.concurrent.test.leetcode.most100;


import java.util.List;

/**
 * https://leetcode.com/problems/longest-common-subsequence/description/
 * <p>
 * 1143. Longest Common Subsequence
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the
 * relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 */
public class CommonSubSequenceOfString {

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        char[] mArray = text1.toCharArray();
        char[] nArray = text2.toCharArray();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (mArray[i - 1] == nArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static int longestCommonSubsequence1(String text1, String text2) {

        List<Character> charList = text1.chars().mapToObj(c -> (char) c).toList();
        int charCounter = 0;
        int charIndex = 0;
        int maxSubString = 0;

        for (int i = 0; i < text2.length(); i++) {
            int i1 = charList.indexOf(text2.charAt(i));
            if (i1 >= charIndex) {
                charCounter++;
                charIndex = i1;
                if (maxSubString < charCounter) {
                    maxSubString = charCounter;
                }
            } else {
                charCounter = 0;
                charIndex = 0;
            }
        }

        return maxSubString;
    }

    public static void main(String[] args) {
        String text1 = "dineshssss";
        String text2 = "aaaneshdddd";
        System.out.println("Length of LCS: " + longestCommonSubsequence(text1, text2)); // Output: 3
        System.out.println("Length of LCS: " + longestCommonSubsequence1(text1, text2)); // Output: 3
//        System.out.println("Length of LCS: " + longestCommonSubsequence1(text1, text2)); // Output: 3
//        System.out.println("Length of LCS: " + longestCommonSubsequence1(text1, text2)); // Output: 3
//        System.out.println("Length of LCS: " + longestCommonSubsequence1("abcd", "ace")); // Output: 2
//        System.out.println("Length of LCS: " + longestCommonSubsequence1("bl", "yby")); // Output: 1
//        System.out.println("Length of LCS: " + longestCommonSubsequence1("ezupkr", "ubmrapg")); // Output: 3
    }

}
