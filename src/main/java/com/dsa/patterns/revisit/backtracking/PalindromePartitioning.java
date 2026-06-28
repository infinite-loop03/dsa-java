package com.dsa.patterns.revisit.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> results) {
        if (start == s.length()) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (!isPalindrome(s, start, end)) continue;
            path.add(s.substring(start, end + 1));
            backtrack(s, end + 1, path, results);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
