package com.dsa.patterns.revision.day21;

public class SearchA2DMatrix {

    static void main() {
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 2;
        System.out.println(searchA2DMatrix.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = matrix[mid / cols][mid % cols];
            if (value == target) return true;
            if (value > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

}
