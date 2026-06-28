package com.dsa.patterns.revisit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSumII.combination(candidates, target));
    }

    private List<List<Integer>> combination(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> path, List<List<Integer>> results) {
        if (remaining == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i + 1, path, results);
            path.removeLast();
        }
    }
}
