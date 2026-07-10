package com.dsa.patterns.dailyquestion;

import java.util.Arrays;

public class PathExistenceQueriesInAGraphI {

    public static void main(String[] args) {
        PathExistenceQueriesInAGraphI pathExistenceQueriesInAGraphI = new PathExistenceQueriesInAGraphI();
        int n = 2;
        int[] nums = {1, 3};
        int maxDiff = 1;
        int[][] queries = {
                {0, 0},
                {0, 1}
        };
        System.out.println(Arrays.toString(pathExistenceQueriesInAGraphI.pathExistenceQueries(n, nums, maxDiff, queries)));
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        UnionFind unionFind = new UnionFind(n);

        boolean[] result = new boolean[queries.length];
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                unionFind.union(i, i + 1);
            }
        }

        for (int[] query : queries) {
            result[count++] = unionFind.find(query[0]) == unionFind.find(query[1]);
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
