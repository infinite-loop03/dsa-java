package com.dsa.patterns.revision.arrays;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {1, 4, 4};
        int target = 4;
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                minLength = Math.min(end - start + 1, minLength);
                sum -= nums[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
