package com.dsa.patterns.dynamicprogramming;

import java.util.Arrays;

public class MinimumNumberOfRemovalsToMakeMountainArray {

    public static void main(String[] args) {
        MinimumNumberOfRemovalsToMakeMountainArray minimumNumberOfRemovalsToMakeMountainArray = new MinimumNumberOfRemovalsToMakeMountainArray();
        int[] nums = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println(minimumNumberOfRemovalsToMakeMountainArray.minimumMountainRemovals(nums));
    }

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
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

        return n - maxLength;
    }
}
