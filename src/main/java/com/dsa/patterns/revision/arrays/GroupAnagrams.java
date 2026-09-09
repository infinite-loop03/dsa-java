package com.dsa.patterns.revision.arrays;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) throw new IllegalArgumentException("strs cannot be null");
        Map<String, List<String>> keyToAnagrams = new HashMap<>();

        for (String str : strs) {
            String key = getAnagramKey(str);
            keyToAnagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(keyToAnagrams.values());
    }

    private String getAnagramKey(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                sb.append((char)('a' + i));
                sb.append(freq[i]);
            }
        }
        return sb.toString();
    }

}
