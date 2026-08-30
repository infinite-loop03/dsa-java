package com.dsa.patterns.dailyquestion;

public class RemovingMinimumAndMaximumFromArray {

    public static void main(String[] args) {
        RemovingMinimumAndMaximumFromArray removingMinimumAndMaximumFromArray = new RemovingMinimumAndMaximumFromArray();
        int[] nums = {-14, 61, 29, -18, 59, 13, -67, -16, 55, -57, 7, 74};
        System.out.println(removingMinimumAndMaximumFromArray.minimumDeletions(nums));
    }

    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[minIndex] > nums[i]) {
                minIndex = i;
            }
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        int left = Math.max(maxIndex, minIndex) + 1;
        int right = n - Math.min(maxIndex, minIndex);

        int both = Math.min(maxIndex, minIndex) + 1
                + n - Math.max(maxIndex, minIndex);

        return Math.min(left, Math.min(right, both));
    }
}
