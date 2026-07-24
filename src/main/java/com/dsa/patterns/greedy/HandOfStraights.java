package com.dsa.patterns.greedy;

import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {

    public static void main(String[] args) {
        HandOfStraights handOfStraights = new HandOfStraights();
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        System.out.println(handOfStraights.isNStraightHand(hand, groupSize));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int handSize = hand.length;
        if (handSize % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        for (int num : hand) {
            int start = num;
            while (cardCount.getOrDefault(start - 1, 0) > 0) start--;
            while (start <= num) {
                while (cardCount.getOrDefault(start, 0) > 0) {
                    for (int i = start; i < start + groupSize; i++) {
                        if (cardCount.getOrDefault(i, 0) == 0) return false;
                        cardCount.put(i, cardCount.get(i) - 1);
                    }
                }
                start++;
            }
        }

        return true;
    }
}
