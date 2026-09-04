package com.dsa.patterns.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

    public static void main(String[] args) {
        LongestStringChain longestStringChain = new LongestStringChain();
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(longestStringChain.longestStrChain(words));
    }

    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int best = 1;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            best = Math.max(best, dp[i]);
        }
        return best;
    }

    private boolean isPredecessor(String prev, String curr) {
        if (prev.length() + 1 != curr.length()) return false;
        int i = 0;
        int j = 0;

        int mismatch = 0;

        while (i < prev.length() && j < curr.length()) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            } else {
                if (mismatch >= 1) return false;
                mismatch++;
            }
            j++;
        }
        return true;
    }
}
