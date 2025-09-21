package com.concurrent.test.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56: Merge Intervals
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping
 * intervals that cover all the intervals in the input.
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping
 * intervals that cover all the intervals in the input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MergeIntervals {

    public static void main(String[] args) {

        for(int[] array: merge(new int[][]{{1, 4}, {3, 6}, {2, 10}, {12, 18}})) {
            System.out.println(Arrays.toString(array));
        }

        for(int[] array: merge1(new int[][]{{1, 3}, {2, 6}, {1, 10}, {15, 18}})) {
            System.out.println(Arrays.toString(array));
        }
//
//        for(int[] array: merge1(new int[][]{{1, 4}, {3, 6}, {2, 10}, {1, 18}})) {
//            System.out.println(Arrays.toString(array));
//        }

    }

    public static int[][] merge(int[][] intervals) {

        int i = 0;

        int start = intervals[0][0];
        int end = intervals[0][1];

        int[][] result = new int[intervals.length][2];
        int count = 0;

        while (i < intervals.length - 1) {

            int[] next = intervals[i + 1];

            if (end < next[0]) {
                count++;
                start = next[0];
                end = next[1];
            }

            if (end > next[0]) {
                end = next[1];
            }

            result[count][0] = start;
            result[count][1] = end;

            i++;
        }

        return result;
    }

    //        for(int[] array: merge(new int[][]{{1, 4}, {3, 6}, {2, 10}, {12, 18}})) {
    public static int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (end < next[0]) {
                merged.add(new int[]{start, end});
                start = next[0];
                end = next[1];
            } else {
                end = Math.max(end, next[1]);
            }
        }
        merged.add(new int[]{start, end});
        return merged.toArray(new int[merged.size()][]);
    }
}
