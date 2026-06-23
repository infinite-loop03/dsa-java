package com.dsa.patterns.graphs;

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfCompleteComponents {

    public static void main(String[] args) {
        CountTheNumberOfCompleteComponents countTheNumberOfCompleteComponents = new CountTheNumberOfCompleteComponents();
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4}
        };
        System.out.println(countTheNumberOfCompleteComponents.countCompleteComponents(6, edges));
    }

    private int[] parent, rank;

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        Map<Integer, Integer> vertexCount = new HashMap<>();
        Map<Integer, Integer> edgeCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);
            vertexCount.merge(root, 1, Integer::sum);
        }

        for (int[] edge : edges) {
            int root = find(edge[0]);
            edgeCount.merge(root, 1, Integer::sum);
        }

        int result = 0;
        for (int root : vertexCount.keySet()) {
            int v = vertexCount.get(root);
            int e = edgeCount.getOrDefault(root, 0);
            if (e == v * (v - 1) / 2) {
                result++;
            }
        }

        return result;
    }

    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    private void union(int x, int y) {
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

