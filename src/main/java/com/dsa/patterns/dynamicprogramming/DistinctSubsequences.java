package com.dsa.patterns.dynamicprogramming;

public class DistinctSubsequences {

    public static void main(String[] args) {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(distinctSubsequences.numDistinct(s, t));
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

}
