package com.dsa.patterns.dailyquestion;

public class MaximumIceCreamBars {

    public static void main(String[] args) {
        MaximumIceCreamBars maximumIceCreamBars = new MaximumIceCreamBars();
        int[] costs = {1, 3, 2, 4, 1};
        System.out.println(maximumIceCreamBars.maxIceCream(costs, 7));
    }

    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;

        for (int cost : costs) {
            maxCost = Math.max(maxCost, cost);
        }

        int[] freq = new int[maxCost + 1];

        for (int cost : costs) {
            freq[cost]++;
        }

        int bars = 0;

        for (int cost = 1; cost <= maxCost && coins > 0; cost++) {
            if (freq[cost] == 0) {
                continue;
            }

            int canBuy = Math.min(freq[cost], coins / cost);

            bars += canBuy;
            coins -= canBuy * cost;
        }

        return bars;
    }
}
