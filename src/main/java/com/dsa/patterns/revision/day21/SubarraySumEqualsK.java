package com.dsa.patterns.revision.day21;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    static void main() {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(subarraySumEqualsK.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            if (prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum - k);
            }
            prefixSum.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}
