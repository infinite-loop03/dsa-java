package com.dsa.patterns.revisit.dynamicprogramming;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][3];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(
                    dp[i - 1][1],
                    dp[i - 1][0] - prices[i - 1]);
            dp[i][2] = Math.max(
                    dp[i - 1][2],
                    dp[i - 1][1] + prices[i - 1]);
        }

        return Math.max(dp[prices.length][2], 0);
    }
}
