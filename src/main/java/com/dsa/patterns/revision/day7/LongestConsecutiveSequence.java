package com.dsa.patterns.revision.day7;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] nums = {};
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;
        int maxLength = 0;

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int num : nums) uniqueNumbers.add(num);

        for (int num : nums) {
            if (!uniqueNumbers.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (uniqueNumbers.contains(current + 1)) {
                    current++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

}
