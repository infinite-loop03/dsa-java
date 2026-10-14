package com.dsa.patterns.revision.day21;

public class MinimumWindowSubstring {

    static void main() {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "a";
        String t = "a";
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] tFreqMap = new int[128];
        int matchCount = 128;

        for (char c : t.toCharArray()) {
            if (tFreqMap[c] == 0) matchCount--;
            tFreqMap[c]++;
        }

        int minLength = Integer.MAX_VALUE;
        String minWindow = "";

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char rightChar = s.charAt(end);
            tFreqMap[rightChar]--;
            if (tFreqMap[rightChar] == 0) matchCount++;

            while (matchCount == 128) {
                if (minLength > end - start + 1) {
                    minLength = end - start + 1;
                    minWindow = s.substring(start, end + 1);
                }
                char leftChar = s.charAt(start);
                if (tFreqMap[leftChar] == 0) matchCount--;
                tFreqMap[leftChar]++;
                start++;
            }
        }
        return minWindow;
    }
}
