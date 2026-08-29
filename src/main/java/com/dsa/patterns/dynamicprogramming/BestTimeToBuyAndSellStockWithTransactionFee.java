package com.dsa.patterns.dynamicprogramming;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee bestTimeToBuyAndSellStockWithTransactionFee = new BestTimeToBuyAndSellStockWithTransactionFee();
        int[] prices = {1, 3, 7, 5, 10, 3};
        System.out.println(bestTimeToBuyAndSellStockWithTransactionFee.maxProfit(prices, 3));
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE / 2;

        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return Math.max(dp[prices.length][0], 0);
    }
}
