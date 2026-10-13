package com.dsa.patterns.revision.day21;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQuery {

    static void main() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    static class NumArray {

        Map<Integer, Integer> prefixSum = new HashMap<>();

        public NumArray(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                prefixSum.put(i, sum);
            }
        }

        public int sumRange(int left, int right) {
            return left == 0 ? prefixSum.get(right) : prefixSum.get(right) - prefixSum.get(left - 1);
        }
    }
}
