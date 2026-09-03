package com.dsa.patterns.dynamicprogramming;

public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {
        MaxSumIncreasingSubsequence maxSumIncreasingSubsequence = new MaxSumIncreasingSubsequence();
        int[] arr = {5, 3, 2, 4, 7, 9, 8, 2, 3};
        System.out.println(maxSumIncreasingSubsequence.maxSumIS(arr));
    }

    public int maxSumIS(int[] arr) {
        int[] dp = new int[arr.length];
        int ans = 0;
        System.arraycopy(arr, 0, dp, 0, arr.length);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
