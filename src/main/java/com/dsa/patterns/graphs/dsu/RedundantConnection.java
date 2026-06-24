package com.dsa.patterns.graphs.dsu;

public class RedundantConnection {

    static class UnionFind {

        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return false;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public static void main(String[] args) {

    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        UnionFind unionFind = new UnionFind(n + 1);

        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) return edge;
        }

        return new int[]{};
    }
}


