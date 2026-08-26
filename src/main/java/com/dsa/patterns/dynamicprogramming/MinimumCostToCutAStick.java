package com.dsa.patterns.dynamicprogramming;

import java.util.Arrays;

public class MinimumCostToCutAStick {

    public static void main(String[] args) {
        MinimumCostToCutAStick minimumCostToCutAStick = new MinimumCostToCutAStick();
        int[] cuts = {1, 3, 4, 5};
        System.out.println(minimumCostToCutAStick.minCost(7, cuts));
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] boundaries = new int[cuts.length + 2];
        boundaries[0] = 0;
        boundaries[boundaries.length - 1] = n;
        System.arraycopy(cuts, 0, boundaries, 1, boundaries.length - 1 - 1);
        int[][] dp = new int[boundaries.length][boundaries.length];


        for (int len = 2; len < boundaries.length; len++) {
            for (int l = 0; l + len < boundaries.length; l++) {
                int r = l + len;
                dp[l][r] = Integer.MAX_VALUE;

                for (int k = l + 1; k < r; k++) {
                    int cost = dp[l][k] + dp[k][r] + boundaries[r] - boundaries[l];
                    dp[l][r] = Math.min(dp[l][r], cost);
                }
            }
        }
        return dp[0][boundaries.length - 1];
    }
}
