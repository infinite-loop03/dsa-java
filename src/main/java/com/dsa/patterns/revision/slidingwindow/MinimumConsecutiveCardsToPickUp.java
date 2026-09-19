package com.dsa.patterns.revision.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardsToPickUp {

    public static void main(String[] args) {
        MinimumConsecutiveCardsToPickUp minimumConsecutiveCardsToPickUp = new MinimumConsecutiveCardsToPickUp();
        int[] nums = {95, 11, 8, 65, 5, 86, 30, 27, 30, 73, 15, 91, 30, 7, 37, 26, 55, 76, 60, 43, 36, 85, 47, 96, 6};
        System.out.println(minimumConsecutiveCardsToPickUp.minimumCardPickup(nums));
    }

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> cardToFrequency = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        for (int end = 0; end < cards.length; end++) {
            if (cardToFrequency.containsKey(cards[end])) {
                minLength = Math.min(minLength, end - cardToFrequency.get(cards[end]) + 1);
            }
            cardToFrequency.put(cards[end], end);
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
