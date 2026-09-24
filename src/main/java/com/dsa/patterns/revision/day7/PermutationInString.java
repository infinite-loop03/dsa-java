package com.dsa.patterns.revision.day7;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        String s1 = "abc";
        String s2 = "ccccbbbbaaaa";
        System.out.println(permutationInString.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] freqMap = new int[26];
        int matchCount = 26;

        for (char c : s1.toCharArray()) {
            if (freqMap[c - 'a'] == 0) matchCount--;
            freqMap[c - 'a']++;
        }

        int start = 0;
        for (int end = 0; end < s2.length(); end++) {
            char rightChar = s2.charAt(end);
            freqMap[rightChar - 'a']--;
            if (freqMap[rightChar - 'a'] == 0) matchCount++;

            if (end - start + 1 > s1.length()) {
                char leftChar = s2.charAt(start);
                if (freqMap[leftChar - 'a'] == 0) matchCount--;
                freqMap[leftChar - 'a']++;
                start++;
            }

            if (matchCount == 26) return true;
        }
       return false;
    }

}
