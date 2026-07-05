package com.dsa.patterns.dailyquestion;

import java.util.Arrays;

public class MinimumScoreOfAPathBetweenTwoCities {

    int[] minEdge;
    int[] parent;
    int[] rank;

    public static void main(String[] args) {
        MinimumScoreOfAPathBetweenTwoCities minimumScoreOfAPathBetweenTwoCities = new MinimumScoreOfAPathBetweenTwoCities();
        int[][] roads = {
                {1, 2, 2},
                {1, 3, 4},
                {3, 4, 7}
        };
        int n = 4;
        System.out.println(minimumScoreOfAPathBetweenTwoCities.minScore(n, roads));
    }

    public int minScore(int n, int[][] roads) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        minEdge = new int[n + 1];
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            minEdge[find(u)] = Math.min(minEdge[find(u)], w);
            minEdge[find(v)] = Math.min(minEdge[find(v)], w);
            union(u, v);
            minEdge[find(u)] = Math.min(minEdge[find(u)], w);
        }
        return minEdge[find(1)];
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
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }

        parent[rootY] = rootX;
        minEdge[rootX] = Math.min(minEdge[rootX], minEdge[rootY]);
        if (rank[rootX] == rank[rootY]) {
            rank[rootX]++;
        }
    }
}
