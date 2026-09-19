package com.dsa.patterns.revision.slidingwindow;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        String s = "pwwkew";
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int maxLength = 0;
        int[] characterToLastIndexSeen = new int[128];
        Arrays.fill(characterToLastIndexSeen, -1);
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (characterToLastIndexSeen[c] != -1 && characterToLastIndexSeen[c] >= start) {
                start = characterToLastIndexSeen[c] + 1;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            characterToLastIndexSeen[c] = end;
        }
        return maxLength;
    }
}
