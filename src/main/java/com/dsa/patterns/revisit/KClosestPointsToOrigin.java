package com.dsa.patterns.revisit;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] points = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        System.out.println(Arrays.deepToString(kClosestPointsToOrigin.kClosest(points, 1)));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
            int aSquare = a[0] * a[0] + a[1] * a[1];
            int bSquare = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(bSquare, aSquare);
        });

        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.toArray(new int[heap.size()][]);
    }
}
