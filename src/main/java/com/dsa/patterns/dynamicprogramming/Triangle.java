package com.dsa.patterns.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(List.of(2));
        tri.add(List.of(3, 4));
        tri.add(List.of(6, 5, 7));
        tri.add(List.of(4, 1, 8, 3));
        System.out.println(triangle.minimumTotal(tri));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {

                int current = triangle.get(i).get(j);

                int left = dp[i + 1][j];
                int right = dp[i + 1][j + 1];

                dp[i][j] = current + Math.min(left, right);
            }
        }

        return dp[0][0];
    }

}
