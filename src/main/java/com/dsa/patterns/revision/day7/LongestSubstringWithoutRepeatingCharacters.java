package com.dsa.patterns.revision.day7;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Map<Character, Integer> characterToLastSeen = new HashMap<>();

        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (characterToLastSeen.containsKey(c) && characterToLastSeen.get(c) >= start) {
                start = characterToLastSeen.get(c) + 1;
            }
            longest = Math.max(longest, end - start + 1);
            characterToLastSeen.put(c, end);
        }
        return longest;
    }
}
