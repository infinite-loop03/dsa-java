package com.dsa.patterns.revision.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {

    public static void main(String[] args) {
        BinarySubarraysWithSum binarySubarraysWithSum = new BinarySubarraysWithSum();
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(binarySubarraysWithSum.numSubarraysWithSum(nums, goal));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int totalSubarrays = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (prefixSum.containsKey(sum - goal)) {
                totalSubarrays += prefixSum.get(sum - goal);
            }
            prefixSum.merge(sum, 1, Integer::sum);
        }
        return totalSubarrays;
    }
}
