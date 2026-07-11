package com.dsa.patterns.dailyquestion;

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfCompleteComponents {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4},
                {3, 5}
        };
        CountTheNumberOfCompleteComponents countTheNumberOfCompleteComponents = new CountTheNumberOfCompleteComponents();
        System.out.println(countTheNumberOfCompleteComponents.countCompleteComponents(n, edges));
    }

    public int countCompleteComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }

        Map<Integer, Integer> vertexCount = new HashMap<>();
        Map<Integer, Integer> edgeCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            vertexCount.merge(root, 1, Integer::sum);
        }

        for (int[] edge : edges) {
            int root = unionFind.find(edge[0]);
            edgeCount.merge(root, 1, Integer:: sum);
        }

        int result = 0;
        for (int root : vertexCount.keySet()) {
            int v = vertexCount.get(root);
            int e = edgeCount.getOrDefault(root, 0);
            if (e == v * (v - 1) / 2) result++;
        }
        return result;
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
