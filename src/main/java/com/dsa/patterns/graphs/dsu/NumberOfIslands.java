package com.dsa.patterns.graphs.dsu;

public class NumberOfIslands {

    int[] parent, rank;

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numberOfIslands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        parent = new int[rows * cols];
        rank = new int[rows * cols];

        int count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    int id = row * cols + col;
                    parent[id] = id;
                    rank[id] = 0;
                    count++;
                }
            }
        }

        int[][] directions = {{0, 1}, {1, 0}};
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != '1') continue;
                for (int[] direction : directions) {
                    int newRow = row + direction[0], newCol = col + direction[1];
                    if (newRow < rows && newCol < cols && grid[newRow][newCol] == '1') {
                        if (union(row * cols + col, newRow * cols + newCol)) {
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }

    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}
