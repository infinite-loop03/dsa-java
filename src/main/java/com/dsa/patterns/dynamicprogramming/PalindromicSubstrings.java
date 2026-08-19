package com.dsa.patterns.dynamicprogramming;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        String s = "aaa";
        System.out.println(palindromicSubstrings.countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expandFromCenter(s, i, i) + expandFromCenter(s, i, i + 1);
        }
        return count;
    }

    private int expandFromCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}
