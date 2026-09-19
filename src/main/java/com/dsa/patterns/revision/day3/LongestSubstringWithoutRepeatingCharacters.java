package com.dsa.patterns.revision.day3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        String s = "pwwkew";
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToLastIndex = new HashMap<>();
        int start = 0;
        int longest = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (charToLastIndex.containsKey(c) && charToLastIndex.get(c) >= start) {
                start = charToLastIndex.get(c) + 1;
            }
            longest = Math.max(end - start + 1, longest);
            charToLastIndex.put(c, end);
        }
        return longest;
    }
}
