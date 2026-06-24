package com.dsa.patterns.graphs.dsu;

public class NumberOfProvinces {

    public static void main(String[] args) {
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(numberOfProvinces.findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);

        int provinces = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (unionFind.find(i) == i) {
                provinces++;
            }
        }
        return provinces;
    }

    private static class UnionFind {

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

        public void union(int x, int y) {
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


