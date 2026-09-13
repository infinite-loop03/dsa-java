package com.dsa.patterns.revision.twopointers;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersectionOfTwoArrays.intersection(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<>();

        for (int num : nums1) nums1Set.add(num);

        Set<Integer> result = new HashSet<>();

        for (int num : nums2) {
            if (nums1Set.contains(num)) {
                result.add(num);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
