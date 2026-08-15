package com.dsa.patterns.dailyquestion;

public class LongestSubsequenceWithNonZeroBitwiseXOR {

    public static void main(String[] args) {
        LongestSubsequenceWithNonZeroBitwiseXOR longestSubsequenceWithNonZeroBitwiseXOR = new LongestSubsequenceWithNonZeroBitwiseXOR();
        int[] nums = {1, 2, 3};
        System.out.println(longestSubsequenceWithNonZeroBitwiseXOR.longestSubsequence(nums));
        System.out.println(2 ^ 3);
    }

    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        boolean allZero = true;

        for (int x : nums) {
            totalXor ^= x;
            if (x > 0) {
                allZero = false;
            }
        }
        if (totalXor > 0) return n;

        return allZero ? 0 : n - 1;
    }

}
