package com.dsa.patterns.graphs;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    public static void main(String[] args) {
        NumberOfDistinctIslands numberOfDistinctIslands = new NumberOfDistinctIslands();
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println(numberOfDistinctIslands.numDistinctIslands(grid));
    }

    public int numDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Set<String> shapes = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    StringBuilder path = new StringBuilder();
                    dfs(grid, row, col, path, 'S');
                    shapes.add(path.toString());
                }
            }
        }
        shapes.forEach(System.out::println);
        return shapes.size();
    }

    private void dfs(int[][] grid, int row, int col, StringBuilder path, char direction) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;
        path.append(direction);

        dfs(grid, row + 1, col, path, 'D');
        dfs(grid, row - 1, col, path, 'U');
        dfs(grid, row, col + 1, path, 'R');
        dfs(grid, row, col - 1, path, 'L');

        path.append('B');
    }
}
