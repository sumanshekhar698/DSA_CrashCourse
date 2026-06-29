package com.etechniketan.dsa.arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
public class _121BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
//        you can buy and sell only once
        int[] nums = {7, 1, 5, 3, 6, 4};
        int profit = maxProfitNaive(nums);
        System.out.println(profit);
        profit = maxProfitOptimized(nums);
        System.out.println(profit);
    }

    private static int maxProfitNaive(int[] nums) {
//        O(n^2) time ;
        int maxProfit = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                maxProfit = Integer.max(nums[j] - nums[i], maxProfit);
            }
        }
        return maxProfit;
    }


    static int maxProfitOptimized(int[] nums) {
        // Edge case: if the array is empty or has only 1 day, no profit can be made
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int maxProfit = 0;
        // Start by assuming the first day has the lowest price we've seen so far
        int min = nums[0];

        // We can safely start the loop from day 1 (index 1)
        for (int i = 1; i < nums.length; i++) {
            min = Integer.min(min, nums[i]);
            maxProfit = Integer.max(maxProfit, nums[i] - min);
        }

        return maxProfit;
    }
}
