package com.etechniketan.dsa.arrays.algo;

public class _53MaximumSubarrayUsingKadanesAlgo {


    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};//[4, -1, 2, 1])
    }

    public int maxSubArrayKadanesPro(int[] nums) {

        int sum = nums[0];//will have at least one element
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = Integer.max(nums[i], sum + nums[i]);// max of current element + previous max + current element
            max = Integer.max(sum, max);

        }
        return max;

    }


    public int maxSubArrayKadanes(int[] nums) {
        // Will have at least one element
        int sum = nums[0];
        int max = sum;

        for (int i = 1; i < nums.length; i++) {

            // If the previous running sum is negative, it drags us down.
            // We drop it and start a brand-new subarray from the current element.
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum = sum + nums[i];
            }

            // 2. Logic for: max = Integer.max(sum, max)
            // If our current running sum is better than the best we've ever seen, update max.
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }




    public int maxSubArrayBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;

        // Outer loop selects the starting point of the subarray
        for (int i = 0; i < nums.length; i++) {
            int currentSubarraySum = 0;

            // Inner loop selects the ending point and accumulates the sum
            for (int j = i; j < nums.length; j++) {
                currentSubarraySum += nums[j];

                // Update max if the current subarray sum is larger
                max = Integer.max(max, currentSubarraySum);
            }
        }
        return max;
    }
}
