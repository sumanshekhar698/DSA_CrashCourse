package com.etechniketan.dsa.basics;

public class PrimeChecker {

    public static boolean isPrime(int number) {
        // 1. Numbers less than or equal to 1 are not prime
        if (number <= 1) {
            return false;
        }

        // 2. Check every number from 2 up to the square root of 'number'
//        for (int i = 2; i <= Math.sqrt(number); i++) {
        for (int i = 2; i * i <= number; i++) {
            // If the number is divisible by i, it's not prime
            if (number % i == 0) {
                return false;
            }
        }

        // 3. If no factors were found, it is prime
        return true;
    }

    public static void main(String[] args) {
        int num = 17;

        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}