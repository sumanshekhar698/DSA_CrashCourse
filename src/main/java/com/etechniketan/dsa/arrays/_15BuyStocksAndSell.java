package com.etechniketan.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class _15BuyStocksAndSell {

    public static void main(String[] args) {
        int[] inputPrice = {7, 1, 5, 3, 6, 4};
//		A single day price will not give you any profit
        // A descending array will always give us LOSS So profit = 0
        //  An ascending array will always give us PROFIT = final-initial

        System.out.println("Original ==> " + Arrays.toString(inputPrice));
        int profit = maxProfitOptimizedLinear(inputPrice);
        System.out.println("PROFIT ==> " + profit);
    }

    private static int maxProfitOptimizedLinear(int[] inputPrice) {
        // buy at cheapest and sell at highest
        int profit = 0;
        for (int i = 1; i < inputPrice.length; i++) {
            if (inputPrice[i] > inputPrice[i - 1])
                profit += (inputPrice[i] - inputPrice[i - 1]);
            // ultimately, we will be adding the diff of peak and trough
        }
        return profit;
    }


}
