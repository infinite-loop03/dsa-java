package com.dsa.patterns.dailyquestion;

import java.util.Arrays;

public class DistributeElementsIntoTwoArraysI {

    public static void main(String[] args) {
        DistributeElementsIntoTwoArraysI distributeElementsIntoTwoArraysI = new DistributeElementsIntoTwoArraysI();
        int[] nums = {5, 4, 3, 8};
        System.out.println(Arrays.toString(distributeElementsIntoTwoArraysI.resultArray(nums)));
    }

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        int index = 0;
        int reverseIndex = n - 1;

        arr[index] = nums[0];
        arr[reverseIndex] = nums[1];

        for (int i = 2; i < n; i++) {
            if (arr[index] > arr[reverseIndex]) arr[++index] = nums[i];
            else arr[--reverseIndex] = nums[i];
        }

        int left = reverseIndex;
        int right = n - 1;

        while (left < right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }

        return arr;
    }

}
