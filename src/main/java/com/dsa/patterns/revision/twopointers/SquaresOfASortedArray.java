package com.dsa.patterns.revision.twopointers;

import java.util.Arrays;

public class SquaresOfASortedArray {

    public static void main(String[] args) {
        SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
        int[] nums = {-4, 3, 2, 1};
        System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(nums)));
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] result = new int[nums.length];

        for (int indexPosition = nums.length - 1; indexPosition >= 0; indexPosition--) {
            int number;
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                number = nums[left];
                left++;
            } else {
                number = nums[right];
                right--;
            }
            result[indexPosition] = number * number;
        }
        return result;
    }
}
