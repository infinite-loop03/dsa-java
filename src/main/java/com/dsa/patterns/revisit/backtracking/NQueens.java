package com.dsa.patterns.revisit.backtracking;

import java.util.*;

public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int n = 4;
        System.out.println(nQueens.solveNQueens(n));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();

        backtrack(0, board, columns, diagonal1, diagonal2, results);
        return results;
    }

    private void backtrack(int row, char[][] board, Set<Integer> columns, Set<Integer> diagonal1, Set<Integer> diagonal2, List<List<String>> results) {
        if (row == board.length) {
            results.add(buildBoard(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (columns.contains(col) || diagonal1.contains(row - col) || diagonal2.contains(row + col)) continue;

            board[row][col] = 'Q';
            columns.add(col);
            diagonal1.add(row - col);
            diagonal2.add(row + col);

            backtrack(row + 1, board, columns, diagonal1, diagonal2, results);

            board[row][col] = '.';
            columns.remove(col);
            diagonal1.remove(row - col);
            diagonal2.remove(row + col);
        }
    }

    private List<String> buildBoard(char[][] board) {
        List<String> answer = new ArrayList<>();
        for (char[] row : board) {
            answer.add(new String(row));
        }
        return answer;
    }
}
