package com.dsa.patterns.revision.slidingwindow;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(permutationInString.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Frequency = new int[26];

        for (char c : s1.toCharArray()) {
            s1Frequency[c - 'a']++;
        }

        int start = 0;
        int matchCount = 0;
        int required = 0;

        for (int freq : s1Frequency) {
            if (freq > 0) required++;
        }

        for (int end = 0; end < s2.length(); end++) {
            char c = s2.charAt(end);
            s1Frequency[c - 'a']--;

            if (s1Frequency[c - 'a'] == 0) matchCount++;

            if (end - start + 1 > s1.length()) {
                char leftChar = s2.charAt(start);
                if (s1Frequency[leftChar - 'a'] == 0) matchCount--;
                s1Frequency[leftChar - 'a']++;
                start++;
            }

            if (matchCount == required) return true;
        }
        return false;
    }
}
