package com.dsa.patterns.revision.day21;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : nums) {
            uniqueNumbers.add(num);
        }

        for (int num : nums) {
            if (!uniqueNumbers.contains(num - 1)) {
                int length = 1;
                int current = num;

                while (uniqueNumbers.contains(current + 1)) {
                    length++;
                    current++;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
