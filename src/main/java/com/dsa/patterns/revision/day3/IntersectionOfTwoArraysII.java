package com.dsa.patterns.revision.day3;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersectionOfTwoArraysII.intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> numberToFrequency = new HashMap<>();

        for (int num : nums1) {
            numberToFrequency.merge(num, 1, Integer::sum);
        }

        for (int num : nums2) {
            if (numberToFrequency.containsKey(num)) {
                intersection.add(num);
                numberToFrequency.merge(num, -1, Integer::sum);
                if (numberToFrequency.get(num) == 0) numberToFrequency.remove(num);
            }
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

}
