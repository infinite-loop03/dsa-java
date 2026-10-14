package com.dsa.patterns.revision.day7;

public class KokoEatingBananas {

    static void main() {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int[] piles = {30,11,23,4,20};
        int h = 6;
        System.out.println(kokoEatingBananas.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canFinish(mid, piles, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canFinish(int minEatingSpeed, int[] piles, int h) {
        int hours = 0;

        for (int pile : piles) {
            hours += pile / minEatingSpeed;
            if (pile % minEatingSpeed > 0) hours++;
        }
        return hours <= h;
    }
}
