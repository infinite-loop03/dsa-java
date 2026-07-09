package com.dsa.patterns.revisit.second.graphs;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        System.out.println(alienDictionary.alienOrder(words));
    }

    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int minLen = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);

            for (char neighbor : graph.get(curr)) {

                indegree.put(neighbor, indegree.get(neighbor) - 1);

                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (sb.length() != indegree.size()) {
            return "";
        }

        return sb.toString();
    }
}
