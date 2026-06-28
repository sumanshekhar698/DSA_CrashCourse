package com.etechniketan.dsa.basics;

public class _3_FibonacciSeries {

    public static void main(String[] args) {

        System.out.println("Fibonacci Series: ");
        int n = 5;
        int x = 0, y = 1, z;


        for (int i = 0; i < n; i++) {
            System.out.print(x + " ");
            z = x + y;

            x = y;
            y = z;
        }

        System.out.println("Fib of 5: " + fib(5));
    }

    static int fib(int n) {
        if (n <= 1) {
            return n;//base case 0 and 1
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    static int fibMemoized(int n) {
        int[] memo = new int[n + 1];
        return fibHelper(n, memo);
    }

    private static int fibHelper(int n, int[] memo) {
        // Base cases
        if (n == 0 || n == 1) {
            return n;
        }

        // Check if the value was already calculated
        if (memo[n] != 0) {
            return memo[n];
        }

        // Store the calculated value in the memo array before returning
        memo[n] = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);

        return memo[n];
    }

}
