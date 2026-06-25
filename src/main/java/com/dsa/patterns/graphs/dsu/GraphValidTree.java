package com.dsa.patterns.graphs.dsu;

public class GraphValidTree {

    public static void main(String[] args) {
        GraphValidTree graphValidTree = new GraphValidTree();
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 3},
                {1, 4}
        };
        System.out.println(graphValidTree.validTree(5, edges));
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                return false;
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (unionFind.find(i) == i) {
                count++;
            }
        }

        return count == 1;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
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
}
