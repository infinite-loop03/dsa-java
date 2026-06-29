package com.dsa.patterns.revisit.backtracking;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEEDE";
        System.out.println(wordSearch.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (word.charAt(0) == board[row][col]) {
                    if (backtrack(board, word, row, col, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) return true;

        if (board[row][col] == '#'
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow < 0 || newRow >= board.length
                    || newCol < 0 || newCol >= board[0].length) continue;

            if (backtrack(board, word, newRow, newCol, index + 1)) {
                return true;
            }
        }

        board[row][col] = temp;
        return false;
    }
}
