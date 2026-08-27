package com.dsa.patterns.dynamicprogramming;

public class MinimumScoreTriangulationOfPolygon {

    public static void main(String[] args) {
        MinimumScoreTriangulationOfPolygon minimumScoreTriangulationOfPolygon = new MinimumScoreTriangulationOfPolygon();
        int[] values = {1, 3, 1, 4, 1, 5};
        System.out.println(minimumScoreTriangulationOfPolygon.minScoreTriangulation(values));
    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for (int len = 3; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k][r] + values[l] * values[k] * values[r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
