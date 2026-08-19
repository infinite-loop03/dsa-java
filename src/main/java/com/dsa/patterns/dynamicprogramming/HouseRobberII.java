package com.dsa.patterns.dynamicprogramming;

public class HouseRobberII {

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        int[] nums = {1, 2, 3};
        System.out.println(houseRobberII.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(rob(nums, 0, n - 1), rob(nums, 1, n));
    }

    private int rob(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i < end; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
