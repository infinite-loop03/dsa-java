package com.dsa.patterns.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfTapsToOpenToWaterAGarden {

    public static void main(String[] args) {
        MinimumNumberOfTapsToOpenToWaterAGarden minimumNumberOfTapsToOpenToWaterAGarden = new MinimumNumberOfTapsToOpenToWaterAGarden();
        int[] ranges = {1, 2, 1, 0, 2, 1, 0, 1};
        System.out.println(minimumNumberOfTapsToOpenToWaterAGarden.minTaps(7, ranges));
    }

    public int minTaps(int n, int[] ranges) {
        int[][] intervals = new int[n + 1][2];

        for (int i = 0; i <= n; i++) {
            intervals[i][0] = i - ranges[i];
            intervals[i][1] = i + ranges[i];
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int count = 0;
        int maxEnd = 0;
        int currEnd = 0;

        for (int[] interval : intervals) {
            if (interval[0] > maxEnd) return -1;
            if (interval[0] > currEnd) {
                count++;
                currEnd = maxEnd;
            }
            maxEnd = Math.max(maxEnd, interval[1]);
            if (maxEnd >= n) return count + 1;
        }
        return -1;
    }
}
