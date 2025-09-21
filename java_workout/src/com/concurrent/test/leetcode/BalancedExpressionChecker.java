package com.concurrent.test.leetcode;

public class BalancedExpressionChecker {

    public static boolean isBalanced(String s) {
        int low = 0, high = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                low++;
                high++;
            } else if (ch == '}') {
                low--;
                high--;
            } else if (ch == '*') {
                // * can be { (+1), } (-1), or empty (0)
                low--;   // assume * is }
                high++;  // assume * is {
            }

            // Clamp low to zero
            if (low < 0) low = 0;

            // If high < 0, too many closing braces
            if (high < 0) return false;
        }

        // If low == 0, it's balanced
        return low == 0 && high == 0;
    }

    public static boolean isBalanced1(String s) {
        int minOpen = 0; // Minimum number of unmatched '{'
        int maxOpen = 0; // Maximum number of unmatched '{'

        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                minOpen++;
                maxOpen++;
            } else if (ch == '}') {
                minOpen--;
                maxOpen--;
            } else if (ch == '*') {
                // * can be '{' (increase maxOpen), '}' (decrease minOpen), or empty
                minOpen--;   // assume * is '}'
                maxOpen++;   // assume * is '{'
            }

            // Clamp minOpen to zero
            if (minOpen < 0) minOpen = 0;

            // If maxOpen < 0, too many closing braces
            if (maxOpen < 0) return false;
        }

        // If minOpen == 0, it's balanced
        return minOpen == 0;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "{*}",       // Balanced
                "{*{}}",     // Balanced
                "{*}}",      // Not Balanced
                "{{*}}*",    // Balanced
                "{{*}",      // Not Balanced
                "*{*}*",     // Balanced
                "}*{",       // Not Balanced
                "*",         // Balanced
                "{{**}}",    // Balanced
                "{{**}}}",   // Not Balanced
        };

        for (String test : testCases) {
            System.out.println("Expression: " + test + " => " + (isBalanced(test) ? "Balanced" : "Not Balanced"));
        }
    }


}
