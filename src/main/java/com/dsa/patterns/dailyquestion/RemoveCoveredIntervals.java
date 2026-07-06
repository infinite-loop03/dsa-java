package com.dsa.patterns.dailyquestion;

import java.util.Arrays;

public class RemoveCoveredIntervals {

    public static void main(String[] args) {
        RemoveCoveredIntervals removeCoveredIntervals = new RemoveCoveredIntervals();
        int[][] intervals = {
                {1, 4},
                {3, 6},
                {2, 8}
        };
        System.out.println(removeCoveredIntervals.removeCoveredIntervals(intervals));
    }

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int count = 0, maxEnd = 0;

        for (int[] interval : intervals) {
            if (interval[1] > maxEnd) {
                count++;
                maxEnd = interval[1];
            }
        }
        return count;
    }
}
