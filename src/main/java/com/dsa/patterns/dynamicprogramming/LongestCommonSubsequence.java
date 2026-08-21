package com.dsa.patterns.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String text1 = "abc";
        String text2 = "abc";
        System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1, text2));

        int[][] dp =  new int[text1.length() + 1][text2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        dp[0][0] = 0;
        System.out.println(longestCommonSubsequence.longestCommonSubsequence2(text1, text2, dp, text1.length(), text2.length()));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequence2(String text1, String text2, int[][] dp, int i, int j) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) return dp[i][j] = 1 + longestCommonSubsequence2(text1, text2, dp, i - 1, j - 1);
        return Math.max(longestCommonSubsequence2(text1, text2, dp, i - 1, j), longestCommonSubsequence2(text1, text2, dp, i, j - 1));
    }
}
