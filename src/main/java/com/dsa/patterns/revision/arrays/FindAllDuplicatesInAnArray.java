package com.dsa.patterns.revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray findAllDuplicatesInAnArray = new FindAllDuplicatesInAnArray();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findAllDuplicatesInAnArray.findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) result.add(nums[i]);
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
