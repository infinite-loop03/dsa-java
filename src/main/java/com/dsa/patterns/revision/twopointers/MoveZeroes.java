package com.dsa.patterns.revision.twopointers;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;

        int left = 0;

        while (left < nums.length && nums[left] != 0) left++;
        int right = left + 1;

        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            }
            right++;
        }
    }
}
