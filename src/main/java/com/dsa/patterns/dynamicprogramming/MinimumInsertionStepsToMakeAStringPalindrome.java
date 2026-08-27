package com.dsa.patterns.dynamicprogramming;

public class MinimumInsertionStepsToMakeAStringPalindrome {

    public static void main(String[] args) {
        MinimumInsertionStepsToMakeAStringPalindrome minimumInsertionStepsToMakeAStringPalindrome = new MinimumInsertionStepsToMakeAStringPalindrome();
        String s = "leetcode";
        System.out.println(minimumInsertionStepsToMakeAStringPalindrome.minInsertions(s));
    }

    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                if (s.charAt(l) == s.charAt(r)) {
                    dp[l][r] = dp[l + 1][r - 1];
                } else {
                    dp[l][r] = 1 + Math.min(dp[l][r - 1], dp[l + 1][r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
