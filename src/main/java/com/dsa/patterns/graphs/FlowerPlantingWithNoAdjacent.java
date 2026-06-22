package com.dsa.patterns.graphs;

import java.util.*;

public class FlowerPlantingWithNoAdjacent {

    public static void main(String[] args) {
        FlowerPlantingWithNoAdjacent flowerPlantingWithNoAdjacent = new FlowerPlantingWithNoAdjacent();
        int[][] paths = {
                {3, 4},
                {4, 2},
                {3, 2},
                {1, 3}
        };
        System.out.println(Arrays.toString(flowerPlantingWithNoAdjacent.gardenNoAdj(4, paths)));
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        for (int i = 1; i <= n; i++) {
            if (answer[i - 1] == -1) {
                bfs(graph, i, answer);
            }
        }
        return answer;
    }

    private void bfs(Map<Integer, List<Integer>> graph, int start, int[] answer) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            Set<Integer> usedFlowers = new HashSet<>();

            for (int neighbor : graph.get(node)) {
                if (answer[neighbor - 1] != -1) {
                    usedFlowers.add(answer[neighbor - 1]);
                }
            }

            for (int flower = 1; flower <= 4; flower++) {
                if (!usedFlowers.contains(flower)) {
                    answer[node - 1] = flower;
                    break;
                }
            }

            for (int neighbor : graph.get(node)) {
                if (answer[neighbor - 1] == -1) {
                    answer[neighbor - 1] = 0;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
