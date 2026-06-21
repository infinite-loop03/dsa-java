package com.dsa.patterns.graphs;

public class NumberOfProvinces {

    public static void main(String[] args) {
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        int[][] isConnected = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println(numberOfProvinces.findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, i, visited);
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, int node, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(isConnected, i, visited);
            }
        }
    }
}
