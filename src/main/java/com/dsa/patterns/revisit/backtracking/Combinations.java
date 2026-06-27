package com.dsa.patterns.revisit.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 3));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int n, int k, int start, List<Integer> path, List<List<Integer>> results) {
        if (path.size() == k) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(n, k, i + 1, path, results);
            path.removeLast();
        }
    }
}
