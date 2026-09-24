package com.dsa.patterns.revision.day3;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        System.out.println(maxConsecutiveOnesIII.longestOnes(nums, k));
    }

    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;

        int left = 0;
        for (int num : nums) {
            if (num == 0) zeroCount++;
            if (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }
        }
        return nums.length - left;
    }
}
