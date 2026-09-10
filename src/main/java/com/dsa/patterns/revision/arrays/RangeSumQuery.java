package com.dsa.patterns.revision.arrays;

public class RangeSumQuery {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
    }

    static class NumArray {

        private final int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            while (left <= right) {
                sum += nums[left];
                left++;
            }
            return sum;
        }
    }

}
