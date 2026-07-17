package com.dsa.patterns.dailyquestion;

import java.util.Arrays;

public class SumOfGCDOfFormedPairs {

    public static void main(String[] args) {
        SumOfGCDOfFormedPairs sumOfGCDOfFormedPairs = new SumOfGCDOfFormedPairs();
        int[] nums = {2, 6, 4};
        System.out.println(sumOfGCDOfFormedPairs.gcdSum(nums));
    }

    public long gcdSum(int[] nums) {
        int max = Integer.MIN_VALUE;

        int[] prefixGcd = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGcd);

        int left = 0;
        int right = prefixGcd.length - 1;

        long total = 0;

        while (left < right) {
            total += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        return total;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }
}
