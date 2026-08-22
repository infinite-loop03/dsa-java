package com.dsa.patterns.dynamicprogramming;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        System.out.println(partitionEqualSubsetSum.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) return false;

        int targetSum = totalSum / 2;
        boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];

        for (int i = 0; i <= nums.length; i++) dp[i][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int sum = 0; sum <= targetSum; sum++) {
                dp[i][sum] = dp[i - 1][sum];
                if (sum >= nums[i - 1]) {
                    dp[i][sum] = dp[i][sum] || dp[i - 1][sum - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][targetSum];
    }
}
