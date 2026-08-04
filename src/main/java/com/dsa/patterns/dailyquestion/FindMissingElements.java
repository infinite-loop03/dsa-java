package com.dsa.patterns.dailyquestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingElements {

    public static void main(String[] args) {
        FindMissingElements findMissingElements = new FindMissingElements();
        int[] nums = {1, 4, 2, 5};
        System.out.println(findMissingElements.findMissingElements(nums));
    }

    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        Set<Integer> notMissing = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            notMissing.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = min; i < max; i++) {
            if (!notMissing.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
