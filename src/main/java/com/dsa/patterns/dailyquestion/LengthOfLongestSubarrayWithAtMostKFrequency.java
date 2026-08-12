package com.dsa.patterns.dailyquestion;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {

    public static void main(String[] args) {
        LengthOfLongestSubarrayWithAtMostKFrequency lengthOfLongestSubarrayWithAtMostKFrequency = new LengthOfLongestSubarrayWithAtMostKFrequency();
        int[] nums = {1};
        int k = 1;
        System.out.println(lengthOfLongestSubarrayWithAtMostKFrequency.maxSubarrayLength(nums, k));
    }

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        int start = 0;
        int maxSubarray = 0;

        for (int end = 0; end < nums.length; end++) {
            frequency.merge(nums[end], 1, Integer::sum);
            while (frequency.get(nums[end]) > k) {
                frequency.merge(nums[start], -1, Integer::sum);
                start++;
            }
            maxSubarray = Math.max(end - start + 1, maxSubarray);
        }

        return maxSubarray;
    }

}
