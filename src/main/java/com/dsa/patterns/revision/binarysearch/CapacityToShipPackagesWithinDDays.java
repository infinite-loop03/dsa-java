package com.dsa.patterns.revision.binarysearch;

public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(capacityToShipPackagesWithinDDays.shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canShip(mid, weights, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canShip(int capacity, int[] weights, int days) {
        int total = 0;
        int expectedDays = 1;
        for (int weight : weights) {
            total += weight;
            if (total > capacity) {
                expectedDays++;
                total = weight;
            }
        }
        return expectedDays <= days;
    }
}
