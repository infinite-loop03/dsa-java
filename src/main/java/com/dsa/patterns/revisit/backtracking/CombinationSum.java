package com.dsa.patterns.revisit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum.combinations(candidates, target));
    }

    private List<List<Integer>> combinations(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), results, 0);
        return results;
    }

    private void backtrack(int[] candidates, int remaining, List<Integer> path, List<List<Integer>> results, int start) {
        if (remaining < 0) return;

        if (remaining == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) break;
            path.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], path, results, i);
            path.removeLast();
        }
    }
}
