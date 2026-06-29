package com.etechniketan.dsa.bitwise;

public class _07FindTheMissingNumber {
    //	 Given an array of non-duplicating numbers from 1 to n where one number is missing, write an efficient java program to find that missing number.
    public static void main(String[] args) {
        int[] array = {4, 3, 8, 7, 5, 2, 6};
        int missingNumber = findMissingXORSimple(array);
        System.out.println("Missing Number is " + missingNumber);

    }


    private static int findMissingXORSimple(int[] a) {
        int n = a.length;
        int x1 = 0;
        int x2 = 0;

        // 1. XOR all actual elements inside the array
        for (int i = 0; i < n; i++) {
            x1 ^= a[i];
        }

        // 2. XOR all expected elements from 1 to n + 1
        for (int i = 1; i <= n + 1; i++) {
            x2 ^= i;
        }

        // The duplicate numbers cancel out, leaving the missing number
        return x1 ^ x2;
    }


    private static int findMissingNumXORSingleLoop(int[] a) {
        int n = a.length;
        int xorSum = 0;

        // 1. XOR all numbers from 1 to n
        // AND XOR all elements in the array at the same time
        for (int i = 0; i < n; i++) {
            xorSum ^= (i + 1) ^ a[i];
        }

        // 2. XOR the final missing number from the range (n + 1)
        return xorSum ^ (n + 1);
    }


    public static int findMissingNumSumUnsafe(int[] array) {
        int n = array.length + 1;// +1 because one is missing
        int sumOfFirstNNums = n * (n + 1) / 2;
        int actualSumOfArr = 0;
        for (int i = 0; i < array.length; i++) {
            actualSumOfArr += array[i];
        }
        return sumOfFirstNNums - actualSumOfArr;
    }

    static int findMissingNumSumSafe(int a[]) {
        int n = a.length;
        int total = 1;
        for (int i = 2; i <= (n + 1); i++) {
            total += i;
            total -= a[i - 2];// traverse all the array
        }
        return total;
    }
}
