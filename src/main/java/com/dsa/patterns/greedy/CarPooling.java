package com.dsa.patterns.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CarPooling {

    public static void main(String[] args) {
        CarPooling carPooling = new CarPooling();
        int[][] trips = {
                {3, 2, 8},
                {4, 4, 6},
                {10, 8, 9}
        };
        int capacity = 11;
        System.out.println(carPooling.carPooling(trips, capacity));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(trip -> trip[1]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(trip -> trip[2]));

        for (int[] trip : trips) {
            while (!minHeap.isEmpty() && minHeap.peek()[2] <= trip[1]) {
                int[] finishedTrip = minHeap.poll();
                capacity += finishedTrip[0];
            }
            minHeap.offer(trip);
            capacity -= trip[0];
            if (capacity < 0) return false;
        }

        return true;

    }

}
