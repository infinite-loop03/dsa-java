package com.dsa.patterns.revision.day7;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement(s, k));
    }

    public int characterReplacement(String s, int k) {
        int longest = 0;
        int[] freqMap = new int[26];

        int start = 0;
        int maxFrequency = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freqMap[c - 'A']++;
            maxFrequency = Math.max(maxFrequency, freqMap[c - 'A']);
            int length = end - start + 1;
            if (length - maxFrequency > k) {
                freqMap[s.charAt(start) - 'A']--;
                start++;
            }
            longest = Math.max(longest, end - start + 1);
        }

        return longest;
    }

}
