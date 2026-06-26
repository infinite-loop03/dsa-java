package com.dsa.patterns.revisit.second.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        System.out.println(pacificAtlanticWaterFlow.pacificAtlantic(heights));
    }

    private List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] atlantic = new boolean[rows][cols];
        boolean[][] pacific = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int row = 0; row < rows; row++) {
            //pacificQueue.offer(new int[]{row, 0});
            //pacific[row][0] = true;
            dfs(heights, row, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, row, cols - 1, atlantic, Integer.MIN_VALUE);

            //atlanticQueue.offer(new int[]{row, cols - 1});
            //atlantic[row][cols - 1] = true;
        }

        for (int col = 0; col < cols; col++) {
            //pacificQueue.offer(new int[]{0, col});
            //pacific[0][col] = true;

            //atlanticQueue.offer(new int[]{rows - 1, col});
            //atlantic[rows - 1][col] = true;

            dfs(heights, 0, col, pacific, Integer.MIN_VALUE);
            dfs(heights, rows - 1, col, atlantic, Integer.MIN_VALUE);
        }

        //bfs(heights, pacificQueue, pacific);
        //bfs(heights, atlanticQueue, atlantic);

        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < heights.length
                        && newCol >= 0 && newCol < heights[0].length
                        && !visited[newRow][newCol]
                        && heights[newRow][newCol] >= heights[row][col]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int height) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visited[row][col] || heights[row][col] < height) {
            return;
        }

        visited[row][col] = true;

        dfs(heights, row + 1, col, visited, heights[row][col]);
        dfs(heights, row - 1, col, visited, heights[row][col]);
        dfs(heights, row, col + 1, visited, heights[row][col]);
        dfs(heights, row, col - 1, visited, heights[row][col]);
    }
}
