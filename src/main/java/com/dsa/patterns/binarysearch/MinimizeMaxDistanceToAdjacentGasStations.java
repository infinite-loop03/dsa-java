package com.dsa.patterns.binarysearch;

import java.util.Objects;
import java.util.PriorityQueue;

public class MinimizeMaxDistanceToAdjacentGasStations {

    static void main() {
        MinimizeMaxDistanceToAdjacentGasStations minimizeMaxDistanceToAdjacentGasStations = new MinimizeMaxDistanceToAdjacentGasStations();
        int[] stations = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(minimizeMaxDistanceToAdjacentGasStations.minMaxDist(stations, k));
        System.out.println(minimizeMaxDistanceToAdjacentGasStations.minMaxDistUsingHeap(stations, k));
        System.out.println(minimizeMaxDistanceToAdjacentGasStations.minMaxDistUsingHeapUsingBS(stations, k));
    }

    public double minMaxDist(int[] stations, int k) {
        int n = stations.length;
        int[] howMany = new int[n - 1];

        for (int i = 0; i < k; i++) {
            double maxSection = -1;
            int maxInd = -1;
            for (int j = 0; j < n - 1; j++) {
                double diff = stations[j + 1] - stations[j];
                double sectionLength = diff / (howMany[j] + 1);
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = j;
                }
            }
            howMany[maxInd]++;
        }

        double ans = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = stations[i + 1] - stations[i];
            double sectionLength = diff / (howMany[i] + 1);
            ans = Math.max(sectionLength, ans);
        }
        return ans;
    }

    public double minMaxDistUsingHeap(int[] stations, int k) {
        int n = stations.length;
        int[] howMany = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.sectionLength, a.sectionLength));
        for (int i = 0; i < stations.length - 1; i++) {
            pq.offer(new Pair(stations[i + 1] - stations[i], i));
        }
        for (int gasStation = 1; gasStation <= k; gasStation++) {
            Pair section = pq.poll();
            int index = Objects.requireNonNull(section).index();
            howMany[index]++;
            double diff = stations[index + 1] - stations[index];
            double newSectionLength = diff / (double) (howMany[index] + 1);
            pq.offer(new Pair(newSectionLength, index));
        }
        return Objects.requireNonNull(pq.peek()).sectionLength();
    }

    public double minMaxDistUsingHeapUsingBS(int[] stations, int k) {
        int n = stations.length;
        double low = 0;
        double high = 0;

        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, stations[i + 1] - stations[i]);
        }

        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (high + low) / 2.0;
            int count = numberOfGasStations(mid, stations);
            if (count > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private int numberOfGasStations(double dist, int[] stations) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            int numberInBetween = (int) ((stations[i] - stations[i - 1]) / dist);
            if ((stations[i] - stations[i - 1]) / dist == numberInBetween * dist) {
                numberInBetween--;
            }
            count += numberInBetween;
        }
        return count;
    }

    record Pair (double sectionLength, int index){}
}
