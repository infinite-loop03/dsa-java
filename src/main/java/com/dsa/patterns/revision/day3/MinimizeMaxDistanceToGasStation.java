package com.dsa.patterns.revision.day3;

public class MinimizeMaxDistanceToGasStation {

    static void main() {
        MinimizeMaxDistanceToGasStation minimizeMaxDistanceToAdjacentGasStations = new MinimizeMaxDistanceToGasStation();
        int[] stations = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(minimizeMaxDistanceToAdjacentGasStations.minMaxDist(stations, k));
    }

    public double minMaxDist(int[] stations, int k) {
        double low = 0;
        double high = 0;

        for (int i = 0; i < stations.length - 1; i++) {
            high = Math.max(high, stations[i + 1] - stations[i]);
        }

        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;
            if (canPlaceGasStations(mid, stations, k)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    private boolean canPlaceGasStations(double dist, int[] stations, int k) {
        int numberOfStations = 0;

        for (int i = 1; i < stations.length; i++) {
            int count = (int) ((stations[i] - stations[i - 1]) / dist);
            if ((stations[i] - stations[i - 1]) / dist == dist * count) count--;
            numberOfStations += count;
        }
        return numberOfStations <= k;
    }
}
