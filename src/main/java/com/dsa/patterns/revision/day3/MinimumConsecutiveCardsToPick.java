package com.dsa.patterns.revision.day3;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardsToPick {

    public static void main(String[] args) {
        MinimumConsecutiveCardsToPick minimumConsecutiveCardsToPick = new MinimumConsecutiveCardsToPick();
        int[] cards = {3, 4, 2, 3, 4, 7};
        System.out.println(minimumConsecutiveCardsToPick.minimumCardPickup(cards));
    }

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> cardToLastSeen = new HashMap<>();
        int minimumCardsToPickUp = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            if (cardToLastSeen.containsKey(cards[i])) {
                minimumCardsToPickUp = Math.min(minimumCardsToPickUp, i - cardToLastSeen.get(cards[i] + 1));
            }
            cardToLastSeen.put(cards[i], i);
        }
        return minimumCardsToPickUp == Integer.MAX_VALUE ? -1 : minimumCardsToPickUp;
    }
}
