package com.etechniketan.dsa.basics;

public class AverageOfTwoNumbers {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

//        double average = (num1 + num2) / 2.0;
//        System.out.println("The average of" + num1 + " and " + num2 + " is: " + average);

        int avg = (num1 + num2) / 2;
        System.out.println("The average of " + num1 + " and " + num2 + " is: " + avg);

//        Binary Search, you must always assign low to num1 and high to num2 [num2 >= num1]
        int avg3 = num1 + (num2 - num1) / 2;
        System.out.println("The average of " + num1 + " and " + num2 + " is: " + avg3);

//        popularized by Joshua Bloch (and used inside the JDK's Arrays.binarySearch()).
        int avg2 = (num1 + num2) >>> 1;
        System.out.println("The average of " + num1 + " and " + num2 + " is: " + avg2);
    }
}
