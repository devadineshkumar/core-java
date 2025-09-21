package com.concurrent.test.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeAndAddIntervals {

    public static void main(String[] args) {

        for (int[] array : insert(new int[][]{{1, 4}, {3, 6}, {2, 10}, {1, 18}}, new int[]{7, 12})) {
            System.out.println(Arrays.toString(array));
        }

    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] newArray = new int[intervals.length + 1][intervals[0].length];

        int index = 0;
        while (index < intervals.length) {

            if (newInterval != null && Math.max(intervals[index][0], intervals[index][1]) > newInterval[0]) {
                newArray[index] = newInterval;
                newInterval = null;
                index++;
            }

            newArray[index] = intervals[index];
            index++;
        }

        intervals = newArray;

        //Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[1]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        int i = 1;
        List<int[]> result = new ArrayList<>();

        while (i < intervals.length - 1) {

            int[] next = intervals[i];

            if (start < next[0]) {
                start = next[0];
            }

            if (end < next[0] || end < next[1]) {
                end = Math.max(next[0], next[1]);
            } else {
                result.add(new int[]{start, end});
                start = intervals[i + 1][0];
                end = intervals[i + 1][1];
                i++;
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }



}
