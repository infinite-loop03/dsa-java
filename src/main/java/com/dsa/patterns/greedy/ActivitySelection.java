package com.dsa.patterns.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    public static void main(String[] args) {
        ActivitySelection activitySelection = new ActivitySelection();
        int[][] intervals = {
                {1, 3},
                {2, 5},
                {0, 6},
                {3, 7},
                {4, 8}
        };
        System.out.println(activitySelection.maxActivities(intervals));
    }

    private int maxActivities(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] > lastEnd) {
                lastEnd = interval[1];
            } else {
                count++;
            }
        }
        return count;
    }
}
