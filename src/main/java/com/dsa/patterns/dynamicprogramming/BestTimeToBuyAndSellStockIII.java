package com.dsa.patterns.dynamicprogramming;

public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII bestTimeToBuyAndSellStockIII = new BestTimeToBuyAndSellStockIII();
        int[] prices = {7,6,4,3,1};
        System.out.println(bestTimeToBuyAndSellStockIII.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][3][2];

        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE / 2;

        dp[0][1][0] = Integer.MIN_VALUE / 2;
        dp[0][1][1] = Integer.MIN_VALUE / 2;

        dp[0][2][0] = Integer.MIN_VALUE / 2;

        for (int i = 1; i <= prices.length; i++) {
            dp[i][0][0] = dp[i - 1][0][0];

            dp[i][0][1] = Math.max(
                    dp[i - 1][0][1],
                    dp[i - 1][0][0] - prices[i - 1]
            );

            dp[i][1][0] = Math.max(
                    dp[i - 1][1][0],
                    dp[i - 1][0][1] + prices[i - 1]
            );

            dp[i][1][1] = Math.max(
                    dp[i - 1][1][1],
                    dp[i - 1][1][0] - prices[i - 1]
            );

            dp[i][2][0] = Math.max(
                    dp[i - 1][2][0],
                    dp[i - 1][1][1] + prices[i - 1]
            );
        }
        return Math.max(dp[prices.length][2][0], Math.max(dp[prices.length][1][0], dp[prices.length][0][0]));
    }
}
