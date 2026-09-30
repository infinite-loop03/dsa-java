package com.dsa.patterns.revision.day3;

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        System.out.println(new KokoEatingBananas().minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(pile, high);
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

    private boolean canFinish(int mid, int[] piles, int h) {
        int hours = 0;

        for (int pile : piles) {
            hours += pile / mid;
            if (pile % mid > 0) hours++;
        }
        return hours <= h;
    }
}
