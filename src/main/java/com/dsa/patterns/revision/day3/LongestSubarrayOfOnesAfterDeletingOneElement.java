package com.dsa.patterns.revision.day3;

public class LongestSubarrayOfOnesAfterDeletingOneElement {

    public static void main(String[] args) {
        LongestSubarrayOfOnesAfterDeletingOneElement longestSubarrayOfOnesAfterDeletingOneElement = new LongestSubarrayOfOnesAfterDeletingOneElement();
        int[] nums = {1, 1, 1};
        System.out.println(longestSubarrayOfOnesAfterDeletingOneElement.longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int longest = 0;
        int zerosInWindow = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) zerosInWindow++;
            if (zerosInWindow > 1) {
                if (nums[start] == 0) zerosInWindow--;
                start++;
            }
            longest = Math.max(longest, end - start);
        }
        return longest;
    }
}
