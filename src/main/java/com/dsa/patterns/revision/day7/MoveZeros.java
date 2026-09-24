package com.dsa.patterns.revision.day7;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;

        int left = 0;
        int right = left + 1;

        while (right < nums.length) {
            if (nums[left] == 0 && nums[right] != 0) {
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            }
            right++;
        }
    }
}
