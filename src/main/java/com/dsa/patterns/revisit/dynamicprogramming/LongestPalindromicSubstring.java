package com.dsa.patterns.revisit.dynamicprogramming;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbc"));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        int[] ans = {0, 0};

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len < n; l++) {
                int r = l + len;
                if (s.charAt(l) == s.charAt(r) && dp[l + 1][r - 1]) {
                    dp[l][r] = true;
                    ans[0] = l;
                    ans[1] = r;
                }
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }


}
