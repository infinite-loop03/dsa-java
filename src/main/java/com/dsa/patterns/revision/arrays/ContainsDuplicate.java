package com.dsa.patterns.revision.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 4};
        System.out.println(containsDuplicate.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("nums cannot be null or less than 2 elements");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int num : nums) {
            if (!uniqueNumbers.add(num)) return true;
        }

        return false;
    }

}
