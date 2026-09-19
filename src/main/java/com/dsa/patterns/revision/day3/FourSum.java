package com.dsa.patterns.revision.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;
        System.out.println(fourSum.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (nums.length < 4) return quadruplets;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > target) return quadruplets;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] > target) return quadruplets;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(List.of(nums[i], nums[j], nums[left], nums[right]));

                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return quadruplets;
    }
}
