package com.dsa.patterns.greedy;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    public static void main(String[] args) {
        MinimumCostToConnectSticks minimumCostToConnectSticks = new MinimumCostToConnectSticks();
        int[] arr = {4, 2, 7, 6, 9};
        System.out.println(minimumCostToConnectSticks.minCost(arr));
    }

    public int minCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int cost : arr) {
            minHeap.offer(cost);
        }

        int totalCost = 0;

        while (minHeap.size() >= 2) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int total = first + second;
            totalCost += total;
            minHeap.offer(total);
        }
        return totalCost;
    }
}
