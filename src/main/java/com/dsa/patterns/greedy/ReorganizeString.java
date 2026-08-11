package com.dsa.patterns.greedy;

import java.util.*;

public class ReorganizeString {

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("aba"));
    }

    public String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        int maxCount = 0, maxLetter = 0;

        for (char c : s.toCharArray()) {
            if (++count[c - 'a'] > maxCount) {
                maxCount = count[c - 'a'];
                maxLetter = c - 'a';
            }
        }

        if (maxCount > (n + 1) / 2) return "";

        char[] res = new char[n];
        int idx = 0;

        while (count[maxLetter]-- > 0) {
            res[idx] = (char) ('a' + maxLetter);
            idx += 2;
        }

        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                if (idx >= n) idx = 1;
                res[idx] = (char) ('a' + i);
                idx += 2;
            }
        }

        return new String(res);
    }

}
