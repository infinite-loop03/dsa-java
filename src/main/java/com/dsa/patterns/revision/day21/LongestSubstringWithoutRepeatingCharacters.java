package com.dsa.patterns.revision.day21;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    static void main() {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        String s = "pwwkew";
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int start = 0;

        Map<Character, Integer> lastIndexSeen = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (lastIndexSeen.containsKey(c) && lastIndexSeen.get(c) >= start) {
                start = lastIndexSeen.get(c) + 1;
            }
            lastIndexSeen.put(c, end);
            length = Math.max(length, end - start + 1);
        }
        return length;
    }
}
