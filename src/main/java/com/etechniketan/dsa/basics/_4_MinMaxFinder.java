package com.etechniketan.dsa.basics;

public class _4_MinMaxFinder {

    public static void main(String[] args) {
        // Sample Input
        int[] myNumbers = {7, 2, 9, 1, 5};

        // Calling the function
        findMinMax(myNumbers);

        // Testing with an edge case (empty array)
        findMinMax(new int[]{});
    }

    public static void findMinMax(int[] numbers) {
        // 1. Validation (Edge Case Handling)
        if (numbers == null || numbers.length == 0) {
            System.out.println("Error: The array is empty or null.");
            return;
        }

        // 2. Initialization
        // We start by assuming the first element is both the smallest and largest
        int min = numbers[0];
        int max = numbers[0];

        // 3. Iteration (Single Pass)
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i]; // Update max if current element is larger
            } else if (numbers[i] < min) {
                min = numbers[i]; // Update min if current element is smaller
            }
        }

        // 4. Output
        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);
    }
}