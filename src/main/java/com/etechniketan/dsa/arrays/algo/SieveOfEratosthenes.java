package com.etechniketan.dsa.arrays.algo;

import java.util.Arrays;

// Sieve of Eratosthenes is $O(nlog log n)$.
public class SieveOfEratosthenes {

    public static void main(String[] args) {
        int n = 30; // Change this value to find primes up to any range
        findPrimes(n);
    }

    public static void findPrimes(int n) {
        // 1. Create a boolean array "isPrime[0..n]" 
        // We initialize all entries it as true. A value in isPrime[i] 
        // will finally be false if i is Not a prime, else true.
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        // 0 and 1 are not prime numbers
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        // 2. Start the sieve process
        for (int p = 2; p * p <= n; p++) {
            // If isPrime[p] is not changed, then it is prime
            if (isPrime[p]) {
                // Update all multiples of p greater than or equal to the square of it
                // Numbers less than p^2 are already marked by smaller prime factors
                for (int i = p; i <= n; i += p) {//TOO EARLY
//                for (int i = p * 2; i <= n; i += p) {//SAFE BUT REPETITIONS
//                  for (int i = p * p; i <= n; i += p) {// OPTIMIZED
                    isPrime[i] = false;
                }
            }
        }

        // 3. Print all prime numbers
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // New line
    }


}