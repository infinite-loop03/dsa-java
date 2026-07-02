package com.dsa.patterns.dailyquestion;

import java.util.*;

public class FindASafeWalkThroughAGrid {

    public static void main(String[] args) {
        FindASafeWalkThroughAGrid findASafeWalkThroughAGrid = new FindASafeWalkThroughAGrid();
        List<List<Integer>> grid = List.of(List.of(1,1,1), List.of(1,0,1), List.of(1,1,1));
        System.out.println(findASafeWalkThroughAGrid.findSafeWalk(grid, 5));
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size();
        int cols = grid.getFirst().size();

        int[][] distance = new int[rows][cols];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0, 0});
        distance[0][0] = grid.getFirst().getFirst();

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int row = curr[0];
            int col = curr[1];

            if (row == rows - 1 && col == cols - 1) return true;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols) continue;

                int cost = distance[row][col] + grid.get(newRow).get(newCol);

                if (cost >= health) continue;

                if (cost < distance[newRow][newCol]) {
                    distance[newRow][newCol] = cost;
                    if (grid.get(newRow).get(newCol) == 0) {
                        deque.offerFirst(new int[]{newRow, newCol});
                    } else {
                        deque.offerLast(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return false;
    }
}
