package com.dsa.patterns.revision.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        String s = "abab";
        String p = "ab";
        System.out.println(findAllAnagramsInAString.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;

        int matchCount = 26;
        int[] freqMap = new int[26];

        for (char c : p.toCharArray()) {
            if (freqMap[c - 'a'] == 0) matchCount--;
            freqMap[c - 'a']++;
        }

        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char rightChar = s.charAt(end);
            freqMap[rightChar - 'a']--;
            if (freqMap[rightChar - 'a'] == 0) matchCount++;

            if (end - start + 1 > p.length()) {
                char leftChar = s.charAt(start);
                if (freqMap[leftChar - 'a'] == 0) matchCount--;
                freqMap[leftChar - 'a']++;
                start++;
            }

            if (matchCount == 26) result.add(start);
        }
        return result;
    }
}
