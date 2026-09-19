package com.dsa.patterns.revision.day3;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = {0};
        moveZeros.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;

        int left = 0;
        while (left < nums.length && nums[left] != 0) left++;

        for (int right = left + 1; right < nums.length; right++) {
            if (nums[left] == 0 && nums[right] != 0) {
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            }
        }
    }
}