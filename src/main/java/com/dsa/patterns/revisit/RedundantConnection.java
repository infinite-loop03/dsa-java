package com.dsa.patterns.revisit;

import java.util.*;

public class RedundantConnection {

    public static void main(String[] args) {
        RedundantConnection redundantConnection = new RedundantConnection();
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 3}
        };
        System.out.println(Arrays.toString(redundantConnection.findRedundantConnection(edges)));
    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= edges.length; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (isConnected(graph, u, v)) {
                return edge;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[]{};
    }

    private boolean isConnected(Map<Integer, List<Integer>> graph, int source, int target) {
        Set<Integer> visited = new HashSet<>();
        return dfs(graph, source, target, visited);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int node, int target, Set<Integer> visited) {
        if (node == target) return true;
        visited.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                if (dfs(graph, neighbor, target, visited)) return true;
            }
        }

        return false;
    }
}
