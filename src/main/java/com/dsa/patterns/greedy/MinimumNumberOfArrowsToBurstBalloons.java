package com.dsa.patterns.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons minimumNumberOfArrowsToBurstBalloons = new MinimumNumberOfArrowsToBurstBalloons();
        int[][] points = {
                {1, 2},
                {1, 2},
                {1, 2},
                {1, 2}
        };
        System.out.println(minimumNumberOfArrowsToBurstBalloons.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));

        int count = 1;
        int lastEnd = points[0][1];

        for (int point = 1; point < points.length; point++) {
            if (points[point][0] > lastEnd) {
                lastEnd = points[point][1];
                count++;
            }
        }
        return count;
    }
}
