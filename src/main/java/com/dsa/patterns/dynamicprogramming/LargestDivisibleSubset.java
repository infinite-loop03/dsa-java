package com.dsa.patterns.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        int[] nums = {4, 8, 10, 240};
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(nums));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] parent = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > dp[max]) max = i;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = max; i >= 0; i = parent[i]) {
            res.add(nums[i]);
        }
        return res;
    }
}
