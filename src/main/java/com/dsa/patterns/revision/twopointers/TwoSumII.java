package com.dsa.patterns.revision.twopointers;

import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] nums = {-1, 0};
        int target = -1;
        System.out.println(Arrays.toString(twoSumII.twoSum(nums, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else return new int[]{left + 1, right + 1};
        }

        throw new AssertionError("The code should not reach here");
    }
}
