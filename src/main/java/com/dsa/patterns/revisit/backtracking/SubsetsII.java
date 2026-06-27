package com.dsa.patterns.revisit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        int[] nums = {1, 2, 2};
        System.out.println(subsetsII.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);

            backtrack(nums, i + 1, path, result);

            path.removeLast();
        }
    }
}
