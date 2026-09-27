package com.dsa.patterns.revision.binarysearch;

public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(kokoEatingBananas.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;

        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1;
        int right = maxPile;

        while (left <= right) {
            int minEatingSpeed = left + (right - left) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += pile / minEatingSpeed;
                if (pile % minEatingSpeed > 0) {
                    hours++;
                }
            }
            if (hours > h) {
                left = minEatingSpeed + 1;
            } else {
                right = minEatingSpeed - 1;
            }
        }
        return left;
    }
}
