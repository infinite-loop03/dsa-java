package com.dsa.patterns.graphs.dijkstra;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int[][] times = {
                {1, 2, 1}
        };
        System.out.println(networkDelayTime.networkDelayTime(times, 2, 1));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];

            if (cost > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newCost = dist[node] + weight;

                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new int[]{newCost, nextNode});
                }
            }
        }

        int minTime = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            minTime = Math.max(minTime, dist[i]);
        }

        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }
}
