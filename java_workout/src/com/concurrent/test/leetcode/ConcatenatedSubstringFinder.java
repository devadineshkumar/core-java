package com.concurrent.test.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ConcatenatedSubstringFinder {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        for (int i = 0; i <= s.length() - totalLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                int wordStart = i + j * wordLen;
                String word = s.substring(wordStart, wordStart + wordLen);
                if (!wordCount.containsKey(word)) break;

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                if (seen.get(word) > wordCount.get(word)) break;

                j++;
            }
            if (j == words.length) result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        ConcatenatedSubstringFinder finder = new ConcatenatedSubstringFinder();
        String s = "aaaccabefcdabcdef";
        String[] words = {"ab", "cd", "ef"};
        System.out.println(finder.findSubstring(s, words)); // Output: [0, 6]
//
//
//        s = "barfoofoobarthefoobarman";
//        words = new String[]{"bar", "foo", "the"};
//        System.out.println(finder.findSubstring(s, words));


    }
}


