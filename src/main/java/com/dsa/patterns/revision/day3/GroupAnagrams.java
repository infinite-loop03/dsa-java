package com.dsa.patterns.revision.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            String key = getFrequencyKey(str);
            anagrams.computeIfAbsent(key, _ -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }

    private String getFrequencyKey(String str) {
        int[] freq = new int[26];
        StringBuilder key = new StringBuilder();

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                key.append((char) ('a' + i));
                key.append(freq[i]);
            }
        }

        return key.toString();
    }
}
