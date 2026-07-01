package com.dsa.patterns.dailyquestion;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindTheSafestPathInAGrid {

    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(List.of(0,0,1), List.of(0,0,0), List.of(0,0,0));
        FindTheSafestPathInAGrid findTheSafestPathInAGrid = new FindTheSafestPathInAGrid();
        System.out.println(findTheSafestPathInAGrid.maximumSafenessFactor(grid));
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] mat = new int[n][n];
        Queue<int[]> multiSource = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    multiSource.offer(new int[]{i, j});
                    mat[i][j] = 0;
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        while (!multiSource.isEmpty()) {
            int size = multiSource.size();
            for (int i = 0; i < size; i++) {
                int[] curr = multiSource.poll();
                int row = curr[0];
                int col = curr[1];
                int val = mat[row][col];
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newRow < mat.length
                            && newCol >= 0 && newCol < mat[0].length
                            && mat[newRow][newCol] == -1) {
                        mat[newRow][newCol] = val + 1;
                        multiSource.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        queue.offer(new int[]{0, 0, mat[0][0]});
        mat[0][0] = -1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            if (row == n - 1 && col == n - 1) return curr[2];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length && mat[newRow][newCol] != -1) {
                    queue.offer(new int[]{newRow, newCol, Math.min(curr[2], mat[newRow][newCol])});
                    mat[newRow][newCol] = -1;
                }
            }
        }
        return -1;
    }
}
