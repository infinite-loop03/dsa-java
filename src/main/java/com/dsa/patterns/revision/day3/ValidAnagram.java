package com.dsa.patterns.revision.day3;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(validAnagram.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) return false;
        }

        return true;
    }

}
