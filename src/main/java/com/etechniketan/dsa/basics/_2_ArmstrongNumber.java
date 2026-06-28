package com.etechniketan.dsa.basics;

public class _2_ArmstrongNumber {

    public static void main(String[] args) {
        int num = 153;
        int originalNum = num;
        int sum = 0;

        int numberOfDigits = (int) (Math.log10(num) + 1);
        System.out.println("Number of digits: " + numberOfDigits);

        while (num != 0) {
            int digit = num % 10;//
            sum += (int) Math.pow(digit, numberOfDigits);//typecasting to prevent lossy conversion

            num /= 10;
        }

        if (sum == originalNum) {
            System.out.println(originalNum + " is an Armstrong number.");
        } else {
            System.out.println(originalNum + " is not an Armstrong number.");
        }
    }
}
