package com.dsa.patterns.graphs;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        System.out.println(Arrays.deepToString(floodFill.floodFill(image, 1, 1, 2)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int previousColor = image[sr][sc];
        dfs(image, sr, sc, color, previousColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int previousColor) {
        if (image == null || sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != previousColor || image[sr][sc] == color) {
            return;
        }

        image[sr][sc] = color;

        dfs(image, sr + 1, sc, color, previousColor);
        dfs(image, sr - 1, sc, color, previousColor);
        dfs(image, sr, sc + 1, color, previousColor);
        dfs(image, sr, sc - 1, color, previousColor);
    }
}
