package com.dsa.patterns.dailyquestion;

public class MaximumProductOfTwoElementsInAnArray {

    public static void main(String[] args) {
        MaximumProductOfTwoElementsInAnArray maximumProductOfTwoElementsInAnArray = new MaximumProductOfTwoElementsInAnArray();
        int[] nums = {3, 4, 5, 2};
        System.out.println(maximumProductOfTwoElementsInAnArray.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int max = 0;
        int secondMax = 0;

        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        return (max - 1) * (secondMax - 1);
    }
}
