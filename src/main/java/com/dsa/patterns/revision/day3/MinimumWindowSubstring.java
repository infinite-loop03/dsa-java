package com.dsa.patterns.revision.day3;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "a";
        String t = "a";
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int minLength = Integer.MAX_VALUE;
        String minWindow = "";

        int charactersToMatch = 128;

        int[] freqMap = new int[128];

        for (char c : t.toCharArray()) {
            if (freqMap[c] == 0) charactersToMatch--;
            freqMap[c]++;
        }

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freqMap[c]--;
            if (freqMap[c] == 0) charactersToMatch++;
            while (charactersToMatch == 128) {
                int length = end - start + 1;
                if (minLength > length) {
                    minLength = length;
                    minWindow = s.substring(start, end + 1);
                }
                if (freqMap[s.charAt(start)] == 0) charactersToMatch--;
                freqMap[s.charAt(start)]++;
                start++;
            }
        }
        return minWindow;
    }
}
