package com.dsa.patterns.dailyquestion;

public class SmallestSubsequenceOfDistinctCharacters {

    public static void main(String[] args) {
        SmallestSubsequenceOfDistinctCharacters smallestSubsequenceOfDistinctCharacters = new SmallestSubsequenceOfDistinctCharacters();
        System.out.println(smallestSubsequenceOfDistinctCharacters.smallestSubsequence("bcabc"));
    }

    public String smallestSubsequence(String s) {
        boolean[] visited = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!visited[ch - 'a']) {
                while (!stringBuilder.isEmpty() && stringBuilder.charAt(stringBuilder.length() - 1) > ch) {
                    if (num[stringBuilder.charAt(stringBuilder.length() - 1) - 'a'] > 0) {
                        visited[stringBuilder.charAt(stringBuilder.length() - 1) - 'a'] = false;
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    } else {
                        break;
                    }
                }
                visited[ch - 'a'] = true;
                stringBuilder.append(ch);
            }
            num[ch  - 'a'] -= 1;
        }
        return stringBuilder.toString();
    }
}
