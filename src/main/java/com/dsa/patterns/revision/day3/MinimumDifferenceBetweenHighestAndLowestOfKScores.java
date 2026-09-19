package com.dsa.patterns.revision.day3;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {

    public static void main(String[] args) {
        MinimumDifferenceBetweenHighestAndLowestOfKScores minimumDifferenceBetweenHighestAndLowestOfKScores = new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        System.out.println(minimumDifferenceBetweenHighestAndLowestOfKScores.minimumDifference(nums, k));
    }

    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);

        int minDifference = Integer.MAX_VALUE;
        int start = 0;

        for (int end = start + k - 1; end < nums.length; end++) {
            minDifference = Math.min(nums[end] - nums[start], minDifference);
            start++;
        }
        return minDifference;
    }
}
