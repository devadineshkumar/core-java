package com.concurrent.test.leetcode.most100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/description/
 * <p>
 * 139. Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence
 * 139. Word Break
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more
 * dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

    public static void main(String[] args) {

        String str = "leetcodeleet";
        String[] word = {"leet", "code"};

        String s = "catsanddog";
        String[] wordDict = new String[]{"cats", "dog", "sand", "and", "cat"};

        //System.out.println(computeWorkBreak(str, word));
        //System.out.println(computeWorkBreak(str, word));
        //System.out.println(wordBreak(str, Arrays.stream(word).toList()));
        //System.out.println(computeWorkBreak(str, word));
        System.out.println(wordBreak(s, Arrays.stream(wordDict).toList()));
        //System.out.println(computeWorkBreak(s, wordDict));
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int strLen = s.length();

        boolean[] dp = new boolean[strLen + 1];
        dp[0] = true;

        for (int i = 1; i <= strLen; i++) {
            for (String word : wordSet) {
                int len = word.length();
                if (i >= len && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }


    /**
     * this is wrong solution which will not cover edge cases.
     * @param str
     * @param word
     * @return
     */
    private static boolean computeWorkBreak(String str, String[] word) {

        List<String> words = new ArrayList<>(Arrays.stream(word).toList());

        int i = 0;
        while (i < str.length()) {
            for (String s : word) {
                String substring = str.substring(i, i + s.length());
                if (s.equalsIgnoreCase(substring)) {
                    i = Math.min(str.length(), i + s.length());
                    break;
                }
            }
        }
        return i == str.length();
    }
}
