package com.dsa.patterns.revision.day21;

public class LongestSubarrayOfOnesAfterDeletingOneElement {

    static void main() {
        LongestSubarrayOfOnesAfterDeletingOneElement longestSubarrayOfOnesAfterDeletingOneElement = new LongestSubarrayOfOnesAfterDeletingOneElement();
        int[] nums = {1, 1, 1};
        System.out.println(longestSubarrayOfOnesAfterDeletingOneElement.longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int start = 0;
        int longest = 0;
        int zeroCount = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) zeroCount++;
            if (zeroCount > 1) {
                if (nums[start] == 0) zeroCount--;
                start++;
            }
            longest = Math.max(longest, end - start);
        }
        return longest;
    }
}
