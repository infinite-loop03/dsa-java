package com.dsa.patterns.dailyquestion;

import java.util.Arrays;

public class MaximumAlternatingSumOfSquares {

    static void main() {
        MaximumAlternatingSumOfSquares maximumAlternatingSumOfSquares = new MaximumAlternatingSumOfSquares();
        int[] nums = {1, -1, 2, -2, 3, -3};
        System.out.println(maximumAlternatingSumOfSquares.maxAlternatingSum(nums));
    }

    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) if (nums[i] < 0) nums[i] = -nums[i];
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        long sum = 0;

        while (left < right) {
            sum += (long) nums[right] * nums[right] - (long) nums[left] * nums[left];
            left++;
            right--;
        }
        if (nums.length % 2 != 0) sum += (long) nums[left] * nums[left];
        return sum;
    }
}
