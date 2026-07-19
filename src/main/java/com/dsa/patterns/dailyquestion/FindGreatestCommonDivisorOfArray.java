package com.dsa.patterns.dailyquestion;

public class FindGreatestCommonDivisorOfArray {

    public static void main(String[] args) {
        FindGreatestCommonDivisorOfArray findGreatestCommonDivisorOfArray = new FindGreatestCommonDivisorOfArray();
        int[] nums = {3, 3};
        System.out.println(findGreatestCommonDivisorOfArray.findGCD(nums));
    }

    public int findGCD(int[] nums) {
        int minimum = nums[0];
        int maximum = nums[0];

        for (int num : nums) {
            minimum = Math.min(minimum, num);
            maximum = Math.max(maximum, num);
        }

        while (minimum != 0) {
            int temp = minimum;
            minimum = maximum % minimum;
            maximum = temp;
        }
        return maximum;
    }
}
