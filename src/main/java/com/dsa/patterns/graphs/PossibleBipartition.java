package com.dsa.patterns.graphs;

import java.util.*;

public class PossibleBipartition {

    public static void main(String[] args) {
        PossibleBipartition possibleBipartition = new PossibleBipartition();
        int[][] dislikes = {
                {1, 2},
                {1, 3},
                {2, 3}
        };
        System.out.println(possibleBipartition.possibleBipartition(3, dislikes));
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] dislike : dislikes) {
            int u = dislike[0];
            int v = dislike[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, i, color)) return false;
            }
        }
        return true;
    }

    private boolean bfs(Map<Integer, List<Integer>> graph, int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
