package com.dsa.patterns.revision.slidingwindow;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] tFrequency = new int[128];
        for (char c : t.toCharArray()) {
            tFrequency[c]++;
        }

        int matchCount = 128;
        for (int i = 0; i < 128; i++) {
            if (tFrequency[i] > 0) matchCount--;
        }

        int start = 0;
        int minLength = Integer.MAX_VALUE;
        String minWindow = "";

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            tFrequency[c]--;
            if (tFrequency[c] == 0) matchCount++;
            while (matchCount == 128) {
                if (minLength > end - start + 1) {
                    minLength = end - start + 1;
                    minWindow = s.substring(start, end + 1);
                }
                tFrequency[s.charAt(start)]++;
                if (tFrequency[s.charAt(start)] > 0) matchCount--;
                start++;
            }
        }
        return minWindow;
    }
}
