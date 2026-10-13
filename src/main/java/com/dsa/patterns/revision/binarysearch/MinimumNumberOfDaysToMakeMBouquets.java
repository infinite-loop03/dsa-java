package com.dsa.patterns.revision.binarysearch;

public class MinimumNumberOfDaysToMakeMBouquets {

    static void main() {
        MinimumNumberOfDaysToMakeMBouquets minimumNumberOfDaysToMakeMBouquets = new MinimumNumberOfDaysToMakeMBouquets();
        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
        int m = 2;
        int k = 3;
        System.out.println(minimumNumberOfDaysToMakeMBouquets.minDays(bloomDay, m, k));
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;
        int low = bloomDay[0];
        int high = bloomDay[0];

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canMake(mid, bloomDay, m, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canMake(int days, int[] bloomDay, int m, int k) {
        int bouquets = 0;
        int flowers = 0;

        for (int day : bloomDay) {
            if (day <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
