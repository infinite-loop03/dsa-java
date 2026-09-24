package com.dsa.patterns.revision.slidingwindow;

public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        int[] nums = {-1};
        int k = 1;
        System.out.println(maximumAverageSubarrayI.findMaxAverage(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        int start = 0;
        double maxAverage = Double.NEGATIVE_INFINITY;

        for (int end = 0; end < nums.length; end++) {
            windowSum += nums[end];
            if (end - start + 1 == k) {
                maxAverage = Math.max(maxAverage, (double) windowSum / k);
                windowSum -= nums[start];
                start++;
            }
        }
        return maxAverage;
    }
}