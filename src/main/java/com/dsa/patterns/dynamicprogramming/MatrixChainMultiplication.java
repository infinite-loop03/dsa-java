package com.dsa.patterns.dynamicprogramming;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication();
        int[] nums = {2, 1, 3, 4};
        System.out.println(matrixChainMultiplication.minMultiplications(nums));
    }

    public int minMultiplications(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int l = 0; l < n - len; l++) {

                int r = l + len;
                dp[l][r] = Integer.MAX_VALUE;

                for (int k = l + 1; k < r; k++) {
                    int cost = dp[l][k] + dp[k][r] + nums[l] * nums[k] * nums[r];

                    dp[l][r] = Math.min(dp[l][r], cost);
                }
            }
        }

        return dp[0][n - 1];
    }
}
