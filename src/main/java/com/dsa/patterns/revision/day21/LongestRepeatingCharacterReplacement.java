package com.dsa.patterns.revision.day21;

public class LongestRepeatingCharacterReplacement {

    static void main() {
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
            char rightChar = s.charAt(end);
            freqMap[rightChar - 'A']++;
            maxFrequency = Math.max(maxFrequency, freqMap[rightChar - 'A']);
            if (end - start + 1 - maxFrequency > k) {
                char leftChar = s.charAt(start);
                freqMap[leftChar - 'A']--;
                start++;
            }
            longest = Math.max(longest, end - start + 1);
        }
        return longest;
    }
}
