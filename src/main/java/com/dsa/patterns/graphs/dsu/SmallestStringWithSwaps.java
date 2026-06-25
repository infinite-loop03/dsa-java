package com.dsa.patterns.graphs.dsu;

import java.util.*;

public class SmallestStringWithSwaps {

    public static void main(String[] args) {
        SmallestStringWithSwaps smallestStringWithSwaps = new SmallestStringWithSwaps();
        List<List<Integer>> pairs = List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2));
        System.out.println(smallestStringWithSwaps.smallestStringWithSwaps("dcab", pairs));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind unionFind = new UnionFind(s.length());

        for (List<Integer> pair : pairs) {
            unionFind.union(pair.getFirst(), pair.getLast());
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            int root = unionFind.find(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).offer(sChar[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sChar.length; i++) {
            sb.append(map.get(unionFind.find(i)).poll());
        }
        return sb.toString();
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
