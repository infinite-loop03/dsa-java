package com.dsa.patterns.dynamicprogramming;

import java.util.Arrays;

public class BurstBalloons {

    public static void main(String[] args) {
        BurstBalloons burstBalloons = new BurstBalloons();
        int[] nums = {3, 1, 5, 8};
        System.out.println(burstBalloons.maxCoins(nums));
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        Arrays.fill(arr, 1);
        if (n - 1 >= 0) System.arraycopy(nums, 0, arr, 1, n);

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 2; len <= n + 2; len++) {
            for (int l = 0; l + len < n + 2; l++) {
                int r = l + len;
                dp[l][r] = Integer.MIN_VALUE;

                for (int k = l + 1; k < r; k++) {
                    int cost = dp[l][k] + dp[k][r] + arr[l] * arr[k] * arr[r];
                    dp[l][r] = Math.max(dp[l][r], cost);
                }
            }
        }
        return dp[0][n + 1];
    }
}
