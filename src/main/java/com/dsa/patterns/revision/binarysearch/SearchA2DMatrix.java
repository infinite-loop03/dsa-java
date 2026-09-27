package com.dsa.patterns.revision.binarysearch;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchA2DMatrix.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid/cols][mid%cols];

            if (matrix[mid/cols][mid%cols] == target) return true;

            if (val < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
