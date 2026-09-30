package com.dsa.patterns.revision.day3;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        String p = "abc";
        String s = "cbaebabacd";
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        System.out.println(findAllAnagramsInAString.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int matchCount = 26;
        int[] pFreqMap = new int[26];

        for (char c : p.toCharArray()) {
            if (pFreqMap[c - 'a'] == 0) matchCount--;
            pFreqMap[c - 'a']++;
        }

        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char rightChar = s.charAt(end);
            pFreqMap[rightChar - 'a']--;
            if (pFreqMap[rightChar - 'a'] == 0) matchCount++;
            if (end - start + 1 > p.length()) {
                char leftChar = s.charAt(start);
                if (pFreqMap[leftChar - 'a'] == 0) matchCount--;
                pFreqMap[leftChar - 'a']++;
                start++;
            }
            if (matchCount == 26) result.add(start);
        }
        return result;
    }
}
