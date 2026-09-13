package com.dsa.patterns.revision.day3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {3, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numberToIndex.containsKey(complement)) {
                return new int[]{numberToIndex.get(complement), i};
            }
            numberToIndex.put(nums[i], i);
        }
        throw new IllegalArgumentException("Target cannot be achieved");
    }

}
