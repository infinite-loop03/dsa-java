package com.dsa.patterns.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        System.out.println(nonOverlappingIntervals.minIntervals(intervals));
    }

    private int minIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] >= lastEnd) {
                lastEnd = interval[1];
            } else {
                count++;
            }
        }
        return count;
    }

}
