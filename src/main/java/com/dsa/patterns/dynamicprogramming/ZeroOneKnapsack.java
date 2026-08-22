package com.dsa.patterns.dynamicprogramming;

public class ZeroOneKnapsack {

    public static void main(String[] args) {
        ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 7;
        System.out.println(zeroOneKnapsack.maximumValue(weights, values, capacity));
    }

    public int maximumValue(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int i = 1; i <= weights.length; i++) {
            for (int c = 0; c <= capacity; c++) {
                int weight = weights[i - 1];
                int value = values[i - 1];
                dp[i][c] = dp[i - 1][c];
                if (c >= weight) {
                    dp[i][c] = Math.max(dp[i][c], value + dp[i - 1][c - weight]);
                }
            }
        }
        return dp[weights.length][capacity];
    }
}
