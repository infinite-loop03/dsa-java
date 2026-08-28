package com.dsa.patterns.dynamicprogramming;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println(longestCommonSubstring.longCommSubstr(s1, s2));
    }

    public int longCommSubstr(String s1, String s2) {
        int max = 0;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

}
