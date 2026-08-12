package com.dsa.patterns.greedy;

import java.util.Arrays;

public class TwoCityScheduling {

    public static void main(String[] args) {
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
        int[][] costs = {
                {10, 20},
                {30, 200},
                {400, 50},
                {30, 20}
        };
        System.out.println(twoCityScheduling.twoCitySchedCost(costs));
    }

    public int twoCitySchedCost(int[][] costs) {
        int[] refund = new int[costs.length];

        int minCost = 0;
        int index = 0;

        for (int[] cost : costs) {
            minCost += cost[0];
            refund[index++] = cost[1] - cost[0];
        }

        Arrays.sort(refund);

        for (int i = 0; i < costs.length / 2; i++) {
            minCost += refund[i];
        }

        return minCost;
    }
}
