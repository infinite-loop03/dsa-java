package com.dsa.patterns.revisit;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {"x", "z", "x"};
        System.out.println(alienDictionary.alienOrder(words));
    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.put(ch, new HashSet<>());
                indegree.put(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) return "";

            int minLen = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.merge(c2, 1, Integer::sum);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (Character ch : graph.keySet()) {
            if (indegree.get(ch) == 0) queue.offer(ch);
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Character curr = queue.poll();
            sb.append(curr);

            for (char neighbor : graph.get(curr)) {
                indegree.merge(neighbor, -1, Integer::sum);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
