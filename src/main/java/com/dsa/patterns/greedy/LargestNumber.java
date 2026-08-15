package com.dsa.patterns.greedy;

import java.util.Arrays;

public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> (b + "" + a).compareTo(a + "" + b));

        StringBuilder result = new StringBuilder();

        for (int num : arr) {
            result.append(num);
        }

        return result.charAt(0) == '0' ? "0" : result.toString();
    }

}
