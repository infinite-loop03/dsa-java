package com.dsa.patterns.revision.day3;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int num : nums) {
            if (!uniqueNumbers.add(num)) return true;
        }
        return false;
    }
}
