package com.dsa.patterns.revision.day21;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    static void main() {
        FindAllDuplicatesInAnArray findAllDuplicatesInAnArray = new FindAllDuplicatesInAnArray();
        int[] nums = {1};
        System.out.println(findAllDuplicatesInAnArray.findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) duplicates.add(index + 1);
            else nums[index] = -nums[index];
        }
        return duplicates;
    }
}
