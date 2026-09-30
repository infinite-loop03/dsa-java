package com.dsa.patterns.revision.day7;

public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(maximumAverageSubarrayI.findMaxAverage(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double maxAverage = Double.NEGATIVE_INFINITY;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            if (end - start + 1 == k) {
                maxAverage = Math.max(maxAverage, sum);
                sum -= nums[start];
                start++;
            }
        }
        return maxAverage / k;
    }
}
