package com.dsa.patterns.revisit.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> results) {
        results.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path, results);
            path.removeLast();
        }
    }
}
