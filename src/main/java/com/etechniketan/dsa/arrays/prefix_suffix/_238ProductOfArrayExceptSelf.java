package com.etechniketan.dsa.arrays.prefix_suffix;

import java.util.Arrays;

public class _238ProductOfArrayExceptSelf {
//    https://leetcode.com/problems/product-of-array-except-self/

    public static void main(String[] args) {

//        int[] nums0 = {2, 3, 4, 5};
        int[] nums1 = {1, 2, 3, 4};
//        int[] nums2 = {-1, 1, 0, -3, 3};
//        int[] nums3 = {3, 6, 5, 2, 1};

        int[] ints = productExceptSelf(nums1);
        System.out.println(Arrays.toString(ints));
    }


    static public int[] productExceptSelfLinear(int[] nums) {

//            time O(n)*3
//            space O(n)*3

        //{2, 3, 4, 5};
        int n = nums.length;
        int[] prefix = new int[n];//prefix Multiple Array
        int[] suffix = new int[n];//suffix multiple Array
        int[] result = new int[n];


//          Original Array {2,   3,   4,   5}
        prefix[0] = 1;
        suffix[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

//            Prefix     {1,    2,   6,    24}
//                       {1 | 1*2 | 2*3 | 2*3*4}

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
//            Suffix    {   60,      20,    5,    1}
//                      {1*5*4*3 | 1*5*4 | 1*5 | 1}


        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }


        System.out.println("PRE => " + Arrays.toString(prefix));
        System.out.println("SUF => " + Arrays.toString(suffix));
        System.out.println("MUL RES=> " + Arrays.toString(result));

        return result;
    }


    static public int[] productExceptSelf(int[] nums) {

//            time O(n*2)
//            space O(n)


        int n = nums.length;
        int[] result = new int[n];

        int tempProduct = 1;
        result[0] = 1;

//            nums =  {2, 3, 4, 5}

//            result = {1, 2, 6, 24}

        //left pass kinda prefix array
        for (int i = 1; i < n; i++) {
            tempProduct *= nums[i - 1];
            result[i] = tempProduct;
        }
//            System.out.println(Arrays.toString(result));

        tempProduct = 1;
        //right pass
        for (int i = n - 2; i >= 0; i--) {
            tempProduct *= nums[i + 1];
            result[i] *= tempProduct;
        }

        return result;
    }


}
