package com.dsa.patterns.dailyquestion;

public class SmallestStableIndexI {

    public static void main(String[] args) {
        SmallestStableIndexI smallestStableIndexI = new SmallestStableIndexI();
        int[] nums = {5, 0, 1, 4};
        System.out.println(smallestStableIndexI.firstStableIndex(nums, 3));
    }

    public int firstStableIndex(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = 0; j < i; j++) {
                max = Math.max(max, nums[j]);
            }
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
            }
            if (max - min <= k) return i;
        }
        return -1;
    }

}
