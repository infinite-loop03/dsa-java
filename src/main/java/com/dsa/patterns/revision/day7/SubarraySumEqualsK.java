package com.dsa.patterns.revision.day7;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySumEqualsK.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int noOfSubarrays = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum = 0;

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
