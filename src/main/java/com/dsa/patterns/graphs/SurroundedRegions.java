package com.dsa.patterns.graphs;

import java.util.Arrays;

public class SurroundedRegions {

    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        surroundedRegions.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if ((row == 0 || col == 0 || row == rows - 1 || col == cols - 1) && board[row][col] == 'O') {
                    dfs(board, row, col);
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == '#') {
                    board[row][col] = 'O';
                } else if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#' || board[row][col] == 'X') {
            return;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
