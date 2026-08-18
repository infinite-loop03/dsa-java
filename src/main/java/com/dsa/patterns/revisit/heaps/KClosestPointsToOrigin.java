package com.dsa.patterns.revisit.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] points = {
                {1, 3},
                {-2, 2}
        };
        int k = 1;
        System.out.println(Arrays.deepToString(kClosestPointsToOrigin.kClosest(points, k)));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int d1 = a[0] * a[0] + a[1] * a[1];
            int d2 = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(d2, d1);
        });

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) pq.poll();
        }

        return pq.toArray(new int[pq.size()][]);
    }
}
