package com.dsa.patterns.revision.day21;

public class CapacityToShipPackagesWithinDDays {

    static void main() {
        CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();
        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;
        System.out.println(capacityToShipPackagesWithinDDays.shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        System.out.println(low);
        System.out.println(high);

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

    private boolean canShip(int minWeight, int[] weights, int days) {
        int minDays = 1;
        int total = 0;

        for (int weight : weights) {
            if (total + weight > minWeight) {
                minDays++;
                total = 0;
            }
            total += weight;
        }
        return minDays <= days;
    }
}
