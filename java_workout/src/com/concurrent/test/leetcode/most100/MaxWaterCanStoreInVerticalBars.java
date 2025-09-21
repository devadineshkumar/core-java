package com.concurrent.test.leetcode.most100;

public class MaxWaterCanStoreInVerticalBars {


    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height1 = new int[]{1, 1};
        System.out.println(maxArea(height1));
        System.out.println(maxArea1(height1));
        System.out.println(maxArea1(height));
    }

    public static int maxArea(int[] height) {

        int minIndex = 0;
        int maxIndex = 0;

        int medianValue = 0;
        int maxValue = 0;

        //        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        for (int i = 0; i < height.length; i++) {

            if (maxValue < height[i]) {
                minIndex = maxIndex;
                medianValue = maxValue;

                maxIndex = i;
                maxValue = height[i];
            } else {
                if (medianValue < height[i] && height[i] != maxValue) {
                    medianValue = height[i];
                    minIndex = i;
                }
            }
        }
        return Math.max(1, medianValue) * Math.max(1, Math.abs((maxIndex - minIndex)));
    }


    public static int maxArea1(int[] height) {


        int left = 0;
        int right = height.length -1;


        int maxArea = 1;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return maxArea;
    }


}
