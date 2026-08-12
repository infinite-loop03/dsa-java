package com.dsa.patterns.revisit.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons minimumNumberOfArrowsToBurstBalloons = new MinimumNumberOfArrowsToBurstBalloons();
        int[][] points = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };
        System.out.println(minimumNumberOfArrowsToBurstBalloons.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));

        int count = 1;
        int lastEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastEnd) {
                count++;
                lastEnd = points[i][1];
            }
        }

        return count;
    }

}
