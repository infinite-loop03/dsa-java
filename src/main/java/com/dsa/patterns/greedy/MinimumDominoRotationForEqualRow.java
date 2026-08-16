package com.dsa.patterns.greedy;

public class MinimumDominoRotationForEqualRow {

    public static void main(String[] args) {
        MinimumDominoRotationForEqualRow minimumDominoRotationForEqualRow = new MinimumDominoRotationForEqualRow();
        int[] tops = {1, 2, 1, 1, 1, 2, 2, 2};
        int[] bottoms = {2, 1, 2, 2, 2, 2, 2, 2};
        System.out.println(minimumDominoRotationForEqualRow.minDominoRotations(tops, bottoms));
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = rotationsFor(tops[0], tops, bottoms);
        return result != -1 ? result : rotationsFor(bottoms[0], tops, bottoms);
    }

    private int rotationsFor(int target, int[] tops, int[] bottoms) {
        int topRotations = 0, bottomRotations = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) return -1;
            if (tops[i] != target) topRotations++;
            else if (bottoms[i] != target) bottomRotations++;
        }
        return Math.min(topRotations, bottomRotations);
    }

}
