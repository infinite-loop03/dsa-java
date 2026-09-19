package com.dsa.patterns.revision.day3;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement(s, k));
    }

    public int characterReplacement(String s, int k) {
        int longest = 0;
        int maxFrequency = 0;
        int[] frequency = new int[26];

        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            frequency[c - 'A']++;
            maxFrequency = Math.max(maxFrequency, frequency[c - 'A']);
            if (end - start + 1 - maxFrequency > k) {
                frequency[s.charAt(start) - 'A']--;
                start++;
            }
            longest = Math.max(longest, end - start + 1);
        }
        return longest;
    }
}
