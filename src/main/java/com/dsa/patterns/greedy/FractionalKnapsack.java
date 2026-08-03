package com.dsa.patterns.greedy;

import java.util.PriorityQueue;

public class FractionalKnapsack {

    public static void main(String[] args) {
        FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();
        int[] val = {120, 100, 60};
        int[] wt = {30, 20, 10};
        int capacity = 50;
        System.out.println(fractionalKnapsack.fractionalKnapsack(val, wt, capacity));
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            double d1 = (double) val[a] / wt[a];
            double d2 = (double) val[b] / wt[b];
            return Double.compare(d2, d1);
        });

        for (int i = 0; i < val.length; i++) {
            pq.offer(i);
        }

        double maxProfit = 0;

        while (capacity > 0 && !pq.isEmpty()) {
            int index = pq.poll();
            if (wt[index] <= capacity) {
                capacity -= wt[index];
                maxProfit += val[index];
            } else {
                maxProfit += ((double) val[index] / wt[index]) * capacity;
                capacity = 0;
            }
        }
        return maxProfit;
    }
}
