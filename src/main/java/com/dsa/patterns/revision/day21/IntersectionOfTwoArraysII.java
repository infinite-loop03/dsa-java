package com.dsa.patterns.revision.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    static void main() {
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersectionOfTwoArraysII.intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return intersect(nums2, nums1);

        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> numberToFrequency = new HashMap<>();

        for (int num : nums2) {
            numberToFrequency.merge(num, 1, Integer::sum);
        }

        for (int num : nums1) {
            if (numberToFrequency.containsKey(num)) {
                result.add(num);
                if (numberToFrequency.merge(num, -1, Integer::sum) == 0) numberToFrequency.remove(num);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
