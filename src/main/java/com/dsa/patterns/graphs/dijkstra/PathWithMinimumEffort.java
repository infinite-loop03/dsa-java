package com.dsa.patterns.graphs.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public static void main(String[] args) {
        PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println(pathWithMinimumEffort.minimumEffortPath(heights));
    }

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] minEffort = new int[rows][cols];
        for (int[] efforts : minEffort) {
            Arrays.fill(efforts, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == rows - 1 && col == cols - 1) return effort;
            if (effort >= minEffort[row][col]) continue;

            minEffort[row][col] = effort;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newEffort = Math.max(effort,
                            Math.abs(heights[newRow][newCol] - heights[row][col]));
                    pq.offer(new int[]{newEffort, newRow, newCol});
                }
            }
        }
        return -1;
    }
}
