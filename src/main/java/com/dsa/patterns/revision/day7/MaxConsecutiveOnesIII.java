package com.dsa.patterns.revision.day7;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
        int[] nums = {1, 1, 1, 1};
        System.out.println(maxConsecutiveOnesIII.longestOnes(nums, 1));
    }

    public int longestOnes(int[] nums, int k) {
        int zero = 0;
        int start = 0;

        for (int num : nums) {
            if (num == 0) zero++;
            if (zero > k) {
                if (nums[start] == 0) zero--;
                start++;
            }
        }
        return nums.length - start;
    }
}
