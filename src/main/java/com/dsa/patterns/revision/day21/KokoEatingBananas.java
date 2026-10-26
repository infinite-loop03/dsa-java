package com.dsa.patterns.revision.day21;

public class KokoEatingBananas {

    static void main() {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(kokoEatingBananas.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high += pile;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canEat(mid, piles, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canEat(int eatingSpeed, int[] piles, int h) {
        int minHours = 0;

        for (int pile : piles) {
            minHours += pile / eatingSpeed;
            if (pile % eatingSpeed > 0) minHours++;

        }

        return minHours <= h;
    }
}
