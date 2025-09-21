package com.concurrent.test.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {


        List<String> result = new ArrayList<>();

        if( n == 0) {
            return  result;
        }
        generate(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void generate(List<String> result, StringBuilder stringBuilder, int open, int close, int n) {

        if(stringBuilder.length() == n * 2) {
            result.add(stringBuilder.toString());
            return;
        }

        if(open < n) {
            generate(result, stringBuilder.append("("), open + 1, close, n);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }

        if(close < open) {
            generate(result, stringBuilder.append(")"), open, close + 1, n);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }

    }
}
