package com.dsa.patterns.revision.arrays;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(validAnagram.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] frequency = new int[26];

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            frequency[c - 'a']--;
            if (frequency[c - 'a'] < 0) return false;
        }

        return true;
    }
}
