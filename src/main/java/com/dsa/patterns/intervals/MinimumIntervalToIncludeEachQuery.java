package com.dsa.patterns.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumIntervalToIncludeEachQuery {

    public static void main(String[] args) {
        MinimumIntervalToIncludeEachQuery minimumIntervalToIncludeEachQuery = new MinimumIntervalToIncludeEachQuery();
        int[][] intervals = {
                {1, 4},
                {2, 4},
                {3, 6},
                {4, 4}
        };
        int[] queries = new int[]{2, 3, 4, 5};
        System.out.println(Arrays.toString(minimumIntervalToIncludeEachQuery.minInterval(intervals, queries)));
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int n = queries.length;
        Integer[] queryIndices = new Integer[n];

        for (int i = 0; i < n; i++) queryIndices[i] = i;

        Arrays.sort(queryIndices, Comparator.comparingInt(a -> queries[a]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[] result = new int[n];
        int i = 0;

        for (int index : queryIndices) {
            int q = queries[index];

            while (i < intervals.length && intervals[i][0] <= q) {
                int size = intervals[i][1] - intervals[i][0] + 1;
                pq.offer(new int[]{size, intervals[i][1]});
                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            result[index] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return result;
    }
}
