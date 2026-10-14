package com.dsa.patterns.revision.day21;

public class PermutationInString {

    static void main() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1FreqMap = new int[26];

        int matchCount = 26;

        for (char c : s1.toCharArray()) {
            if (s1FreqMap[c - 'a'] == 0) matchCount--;
            s1FreqMap[c - 'a']++;
        }

        int start = 0;
        for (int end = 0; end < s2.length(); end++) {
            char rightChar = s2.charAt(end);
            s1FreqMap[rightChar - 'a']--;
            if (s1FreqMap[rightChar - 'a'] == 0) matchCount++;

            if (end - start + 1 > s1.length()) {
                char leftChar = s2.charAt(start);
                if (s1FreqMap[leftChar - 'a'] == 0) matchCount--;
                s1FreqMap[leftChar - 'a']++;
                start++;
            }

            if (matchCount == 26) return true;
        }
        return false;
    }
}
