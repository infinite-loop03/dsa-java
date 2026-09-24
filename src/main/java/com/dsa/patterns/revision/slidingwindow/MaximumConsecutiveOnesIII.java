package com.dsa.patterns.revision.slidingwindow;

public class MaximumConsecutiveOnesIII {

    public static void main(String[] args) {
        MaximumConsecutiveOnesIII maximumConsecutiveOnesIII = new MaximumConsecutiveOnesIII();
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(maximumConsecutiveOnesIII.longestOnes(nums, k));
    }

    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int start = 0;

        for (int num : nums) {
            if (num == 0) zeroCount++;
            if (zeroCount > k) {
                if (nums[start] == 0) zeroCount--;
                start++;
            }
        }
        return nums.length - start;
    }
}
