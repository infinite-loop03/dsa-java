package com.dsa.patterns.revision.day3;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int num : nums) uniqueNumbers.add(num);

        int longest = 0;

        for (int num : nums) {
            if (!uniqueNumbers.contains(num - 1)) {
                int current = num;
                int length = 1;
                while (uniqueNumbers.contains(current + 1)) {
                    current++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
