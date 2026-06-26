package com.dsa.patterns.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = {
                {1, 3},
                {6, 9}
        };
        System.out.println(Arrays.deepToString(insertInterval.insert(intervals, new int[]{2, 5})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            answer.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        answer.add(newInterval);

        while (i < n) {
            answer.add(intervals[i]);
            i++;
        }

        return answer.toArray(new int[answer.size()][]);
    }
}
