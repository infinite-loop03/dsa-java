package com.dsa.patterns.revision.twopointers;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2, 0, 1};
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
                int temp = nums[leftBoundary];
                nums[leftBoundary] = nums[current];
                nums[current] = temp;
                current++;
            } else if (nums[current] == 2) {
                rightBoundary--;
                int temp = nums[rightBoundary];
                nums[rightBoundary] = nums[current];
                nums[current] = temp;
            } else {
                current++;
            }
        }
    }
}
