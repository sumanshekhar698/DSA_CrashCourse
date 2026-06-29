package com.etechniketan.dsa.arrays;

import java.util.HashMap;

public class _560TotalSubarraySumEqualsK {

    public static void main(String[] args) {
        int arr[] = {4, 5, 1, 3, 2, 3, 4}, k = 9;
        int ans = subarraySumUsingPrefixSum(arr, k);
        System.out.println(ans);
    }

    public static int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        // 1. Try every possible starting index 'i'
        for (int i = 0; i < n; i++) {

            // 2. Try every possible ending index 'j' that comes after or at 'i'
            for (int j = i; j < n; j++) {
                int currentSum = 0;

                // 3. Manually loop from 'i' to 'j' to calculate the sum
                for (int kIndex = i; kIndex <= j; kIndex++) {
                    currentSum += nums[kIndex];
                }

                // If the sum matches our target k, increment count
                if (currentSum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int subarraySumUsingPrefixSum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1]; // prefix[0] = 0

        //1.  Build prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int count = 0;

        // 2. Try every subarray [i..j]
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefix[j + 1] - prefix[i];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

/*    static public int subarraySum(int[] nums, int k) {//prefix SUM will bring it to n^2
        int numberOfSubArrays = 0;
        int curSum = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();//prefixSum : Count
        prefixSumMap.put(0, 1);//there is an empty prefix with curSum 0

        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;

            numberOfSubArrays += prefixSumMap.getOrDefault((diff), 0);
            prefixSumMap.put(curSum, prefixSumMap.getOrDefault(curSum, 0) + 1);

        }

        return numberOfSubArrays;

    }*/
}