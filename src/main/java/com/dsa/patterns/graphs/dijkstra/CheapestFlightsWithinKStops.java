package com.dsa.patterns.graphs.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        System.out.println(cheapestFlightsWithinKStops.findCheapestPrice(4, flights, 0, 3, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] time : flights) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v, w});
        }

        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int stops = curr[2];

            if (node == dst) return cost;
            if (stops > k) continue;
            if (stops >= minStops[node]) continue;
            minStops[node] = stops;

            for (int[] neighbor : graph.get(node)) {
                pq.offer(new int[]{cost + neighbor[1], neighbor[0], stops + 1});
            }
        }
        return -1;
    }
}
