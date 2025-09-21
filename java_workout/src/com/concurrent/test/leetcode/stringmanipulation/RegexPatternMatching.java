package com.concurrent.test.leetcode.stringmanipulation;

public class RegexPatternMatching {

    public static void main(String[] args) {
        System.out.println(isMatch("aaaa", "a*"));
    }

    public static boolean isMatch(String s, String p) {
        // Base case: if either string or pattern is null, no match is possible
        if (s == null || p == null) {
            return false;
        }

        // Create DP table where dp[i][j] represents whether s[0...i-1] matches p[0...j-1]
        // Extra row/column for empty string cases
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns like "a*", "a*b*", etc. that can match empty string
        // Only '*' can make a pattern match empty string by consuming zero characters
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                // If current char is '*' and the pattern up to previous char matches empty string,
                // then this pattern also matches empty string (star consumes zero occurrences)
                dp[0][i + 1] = true;
            }
        }

        // Fill the DP table for all combinations of string and pattern
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {

                // Case 1: Pattern character is '.' (wildcard)
                // '.' matches any single character, so result depends on previous state
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                // Case 2: Pattern character exactly matches string character
                // Direct character match, result depends on previous state
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                // Case 3: Pattern character is '*' (most complex case)
                if (p.charAt(j) == '*') {
                    // '*' operates on the previous character in pattern
                    // Check if previous pattern char matches current string char
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        // Previous char doesn't match and isn't wildcard
                        // So '*' must consume zero occurrences - skip the "char*" pattern
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        // Previous char matches current string char OR is wildcard '.'
                        // Three possibilities for '*':
                        dp[i + 1][j + 1] = (dp[i + 1][j] ||  // Zero occurrences: ignore "char*"
                                dp[i][j + 1] ||  // Multiple occurrences: consume current char, keep pattern
                                dp[i + 1][j - 1]);      // One occurrence: consume both char and pattern
                    }
                }
            }
        }

        // Return whether entire string matches entire pattern
        return dp[s.length()][p.length()];
    }

    public static boolean isMatch1(String text, String pattern) {
        return isMatchHelper(text, pattern, 0, 0);
    }

    private static boolean isMatchHelper(String text, String pattern, int textIndex, int patternIndex) {
        // Base case: if we've reached the end of the pattern
        if (patternIndex == pattern.length()) {
            return textIndex == text.length();
        }

        // Check if current characters match
        boolean firstMatch = (textIndex < text.length() &&
                (pattern.charAt(patternIndex) == text.charAt(textIndex) ||
                        pattern.charAt(patternIndex) == '.'));

        // Handle '*' wildcard
        if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
            // Two options with '*':
            // 1. Skip the pattern (zero occurrences)
            // 2. Use the pattern if first character matches, then advance text
            return isMatchHelper(text, pattern, textIndex, patternIndex + 2) ||
                    (firstMatch && isMatchHelper(text, pattern, textIndex + 1, patternIndex));
        } else {
            // No '*', so we need exact match and advance both pointers
            return firstMatch && isMatchHelper(text, pattern, textIndex + 1, patternIndex + 1);
        }
    }


}
