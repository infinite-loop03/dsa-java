package com.dsa.patterns.revision.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : nums) uniqueNumbers.add(num);

        int maxLength = 0;

        for (int num : uniqueNumbers) {
            if (!uniqueNumbers.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (uniqueNumbers.contains(current + 1)) {
                    length++;
                    current++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
