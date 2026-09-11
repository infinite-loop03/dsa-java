package com.dsa.patterns.revision.arrays;

import java.util.Objects;

public class RangeSumQuery {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(2, 5));
    }

    static class NumArray {

        private final int[] sumRange;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) throw new IllegalArgumentException("Nums should have at least 1 element");
            sumRange = new int[nums.length];
            sumRange[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
               sumRange[i] = sumRange[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left > right || left < 0 || right >= sumRange.length) {
                throw new IllegalArgumentException("Invalid values of left and right");
            }

            if (left > 0) {
                return sumRange[right] - sumRange[left - 1];
            }
            return sumRange[right];
        }
    }

}
