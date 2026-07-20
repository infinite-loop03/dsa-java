package com.dsa.patterns.dailyquestion;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

    public static void main(String[] args) {
        Shift2DGrid shift2DGrid = new Shift2DGrid();
        int[][] grid = {
                {3, 8, 1, 9},
                {19, 7, 2, 5},
                {4, 6, 11, 10},
                {12, 0, 21, 13}
        };
        System.out.println(shift2DGrid.shiftGrid(grid, 4));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] flattened = new int[grid.length * grid[0].length];

        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            System.arraycopy(grid[row], 0, flattened, (row * cols), cols);
        }

        k %= flattened.length;

        reverse(flattened, 0, flattened.length - 1);
        reverse(flattened, 0, k - 1);
        reverse(flattened, k, flattened.length - 1);

        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            List<Integer> list = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                list.add(flattened[(row * cols) + col]);
            }
            result.add(list);
        }

        return result;
    }

    void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
