package com.dsa.patterns.revision.day7;

public class CapacityToShipPackagesWithinDDays {

    static void main(String[] args) {
        CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();
        System.out.println(capacityToShipPackagesWithinDDays.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low < high) {
            int minCapacity = low + (high - low) / 2;

            if (canAchieve(minCapacity, weights, days)) {
                high = minCapacity;
            } else {
                low = minCapacity + 1;
            }
        }
        return low;
    }

    private boolean canAchieve(int minCapacity, int[] weights, int days) {

        int minDays = 1;
        int currentWeight = 0;

        for (int weight : weights) {
            if (currentWeight + weight > minCapacity) {
                minDays++;
                currentWeight = 0;
            }
            currentWeight += weight;
        }
        return minDays <= days;
    }
}
