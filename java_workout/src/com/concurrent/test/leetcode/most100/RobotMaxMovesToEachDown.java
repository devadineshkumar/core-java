package com.concurrent.test.leetcode.most100;


/**
 * https://leetcode.com/problems/unique-paths/description/
 * 62. There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the
 * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 */
public class RobotMaxMovesToEachDown {
    public static void main(String[] args) {

        int m = 3;
        int n = 4;

        int unique = computeUniquePath(m, n);
        System.out.println(unique);

        int unique1 = findUniquePath(m + n - 2, Math.min(m - 1, n - 1));
        System.out.println(unique1);
    }

    public static int findUniquePath(int total, int choose) {
        int result = 1;

        for (int i = 1; i <= choose; i++) {
            System.out.println("Result " + result + " Total " + total + " i " + i);
            result = result * (total - i + 1) / i;
        }

        return result;
    }

    private static int computeUniquePath(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill the first row and column with 1s
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
