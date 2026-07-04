package com.dsa.patterns.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkRecoveryPathways {

    public static void main(String[] args) {
        NetworkRecoveryPathways networkRecoveryPathways = new NetworkRecoveryPathways();
        int[][] edges = {
                {0, 1, 7},
                {1, 4, 5},
                {0, 2, 6},
                {2, 3, 6},
                {3, 4, 2},
                {2, 4, 6}
        };
        boolean[] online = {true, true, true, false, true};
        int k = 12;
        System.out.println(networkRecoveryPathways.findMaxPathScore(edges, online, k));
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int l = Integer.MAX_VALUE;
        int r = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (!online[u] || !online[v]) continue;

            graph.get(u).add(new int[]{v, cost});
            l = Math.min(l, cost);
            r = Math.max(r, cost);
        }

        if (!check(graph, l, k, n)) {
            return -1;
        }

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(graph, mid, k, n)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private boolean check(List<List<int[]>> graph, int mid, long k, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];

            if (d > k) return false;
            if (u == n - 1) return true;
            if (d > dist[u]) continue;

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (w < mid) continue;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new long[]{dist[v], v});
                }
            }
        }
        return false;
    }
}
