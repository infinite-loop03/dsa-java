package com.dsa.patterns.dynamicprogramming;

import java.util.Arrays;

public class LongestBitonicSequence {

    public static void main(String[] args) {
        LongestBitonicSequence longestBitonicSequence = new LongestBitonicSequence();
        int[] nums = {5, 9, 7};
        System.out.println(longestBitonicSequence.longestBitonicSequence(nums.length, nums));
    }

    public int longestBitonicSequence(int n, int[] nums) {
        int[] increasing = new int[n];
        int[] decreasing = new int[n];

        Arrays.fill(increasing, 1);
        Arrays.fill(decreasing, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    increasing[i] = Math.max(increasing[i], increasing[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    decreasing[i] = Math.max(decreasing[i], decreasing[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (increasing[i] > 1 && decreasing[i] > 1) {
                maxLength = Math.max(increasing[i] + decreasing[i] - 1, maxLength);
            }
        }

        return maxLength;
    }

}
