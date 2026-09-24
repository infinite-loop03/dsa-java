package com.dsa.patterns.revision.day7;

import java.util.Arrays;

public class SquaresOfASortedArray {

    public static void main(String[] args) {
        SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(nums)));
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        for (int insertPosition = nums.length - 1; insertPosition >= 0; insertPosition--) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[insertPosition] = nums[right] * nums[right];
                right--;
            } else {
                result[insertPosition] = nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }
}
