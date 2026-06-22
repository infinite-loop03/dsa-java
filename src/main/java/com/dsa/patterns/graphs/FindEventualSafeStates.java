package com.dsa.patterns.graphs;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    public static void main(String[] args) {
        FindEventualSafeStates findEventualSafeStates = new FindEventualSafeStates();
        int[][] graph = {
                {1, 2, 3, 4},
                {1, 2},
                {3, 4},
                {0, 4},
                {}
        };
        System.out.println(findEventualSafeStates.eventualSafeNodes(graph));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];

        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!dfs(graph, i, visited, inStack)) {
                answers.add(i);
            }
        }
        return answers;
    }

    private boolean dfs(int[][] graph, int node, boolean[] visited, boolean[] inStack) {
        visited[node] = true;
        inStack[node] = true;

        for (int neighbour : graph[node]) {
            if (!visited[neighbour]) {
                if (dfs(graph, neighbour, visited, inStack)) return true;
            } else if (inStack[neighbour]) {
                return true;
            }
        }

        inStack[node] = false;
        return false;
    }
}
