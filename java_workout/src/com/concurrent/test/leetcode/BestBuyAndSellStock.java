package com.concurrent.test.leetcode;

public class BestBuyAndSellStock {

    public static void main(String[] args) {
        int[] array = new int[]{7, 1, 5, 3, 6, 4, 8};
        int[] array1 = new int[]{1, 2, 4};
        int[] array2 = new int[]{3, 2, 4};
        int[] array3 = new int[]{7, 6, 4, 3, 1};
        int[] array4 = new int[]{2, 4, 1};

        System.out.println(maxProfit(array));
        System.out.println(maxProfit(array1));
        System.out.println(maxProfit(array2));
        System.out.println(maxProfit(array3));
        System.out.println(maxProfit(array4));

    }

    public static int maxProfit(int[] prices) {

        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }
            profit = Math.max(profit, prices[i] - buyPrice);
        }

        return profit;
    }

}
