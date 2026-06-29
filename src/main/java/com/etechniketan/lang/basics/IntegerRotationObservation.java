package com.etechniketan.lang.basics;

public class IntegerRotationObservation {

    public static void main(String[] args) {

        byte a = 127;
        a += 1;
        System.out.println(a);//-128 ROTATION

/*        int i = 0;
        for (; i > -1; i += 10000) {//this loop will definitely stop because of integer rotation
            System.out.println(i);
        }
        System.out.println(i);

        System.out.println();
        byte b = 127;
        b += 30000;
        System.out.println(b);
        System.out.println(Long.MAX_VALUE);*/
    }
}