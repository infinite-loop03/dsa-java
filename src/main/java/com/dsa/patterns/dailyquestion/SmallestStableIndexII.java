package com.dsa.patterns.dailyquestion;

public class SmallestStableIndexII {

    public static void main(String[] args) {
        SmallestStableIndexII smallestStableIndexII = new SmallestStableIndexII();
        int[] nums = {5, 0, 1, 4};
        int k = 3;
        System.out.println(smallestStableIndexII.firstStableIndex(nums, k));
    }

    public int firstStableIndex(int[] nums, int k) {
        int[] minArr = new int[nums.length];
        int min = nums[nums.length - 1];

        for (int i = nums.length - 1; i > -1; i--) {
            min = Math.min(min, nums[i]);
            minArr[i] = Math.min(min, nums[i]);
        }

        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max - minArr[i] <= k) return i;
        }

        return -1;
    }
}
