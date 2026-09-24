package com.dsa.patterns.revision.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public static void main(String[] args) {
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subArraySumEqualsK.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int noOfSubarrays = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0;
        prefixSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (prefixSum.containsKey(sum - k)) {
                noOfSubarrays += prefixSum.get(sum - k);
            }
            prefixSum.merge(sum, 1, Integer::sum);
        }
        return noOfSubarrays;
    }
}
