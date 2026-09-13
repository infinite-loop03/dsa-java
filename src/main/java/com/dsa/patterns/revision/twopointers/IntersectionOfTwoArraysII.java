package com.dsa.patterns.revision.twopointers;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        int[] nums1 = {4, 9, 5, 9};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersectionOfTwoArraysII.intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> numberToFrequency = new HashMap<>();

        for (int num : nums1) {
            numberToFrequency.merge(num, 1, Integer::sum);
        }

        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            if (numberToFrequency.containsKey(num) && numberToFrequency.get(num) > 0) {
                result.add(num);
                numberToFrequency.merge(num, -1, Integer::sum);
                if (numberToFrequency.get(num) == 0) numberToFrequency.remove(num);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
