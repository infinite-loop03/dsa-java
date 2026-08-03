package com.dsa.patterns.revisit.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    public static void main(String[] args) {
        ActivitySelection activitySelection = new ActivitySelection();
        int[][] intervals = {
                {10, 20},
                {12, 25},
                {20, 30}
        };
        System.out.println(activitySelection.activitySelection(intervals));
    }

    public int activitySelection(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int lastEnd = Integer.MIN_VALUE;
        int count  = 0;

        for (int[] interval : intervals) {
            if (interval[0] > lastEnd) {
                count++;
                lastEnd = interval[1];
            }
        }
        return count;
    }

}
