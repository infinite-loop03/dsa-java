package com.dsa.patterns.revision.day7;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "a";
        String t = "a";
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int minWindowLength = s.length();
        String minWindow = "";

        int[] freqMap = new int[128];
        int matchCount = 128;

        for (char c : t.toCharArray()) {
            if (freqMap[c] == 0) matchCount--;
            freqMap[c]++;
        }

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char rightChar = s.charAt(end);
            freqMap[rightChar]--;
            if (freqMap[rightChar] == 0) matchCount++;

            while (matchCount == 128) {
                if (minWindowLength >= end - start + 1) {
                    minWindowLength = end - start + 1;
                    minWindow = s.substring(start, end + 1);
                }

                char leftChar = s.charAt(start);
                if (freqMap[leftChar] == 0) matchCount--;
                freqMap[leftChar]++;
                start++;
            }
        }
        return minWindow;
    }
}
