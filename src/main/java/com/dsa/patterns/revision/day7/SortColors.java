package com.dsa.patterns.revision.day7;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int leftBoundary = -1;
        int rightBoundary = nums.length;
        int current = 0;

        while (current < rightBoundary) {
            if (nums[current] == 0) {
                leftBoundary++;
                nums[current] = nums[leftBoundary];
                nums[leftBoundary] = 0;
                current++;
            } else if (nums[current] == 2) {
                rightBoundary--;
                nums[current] = nums[rightBoundary];
                nums[rightBoundary] = 2;
            } else {
                current++;
            }
        }
    }
}
