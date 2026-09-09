package com.dsa.patterns.revision.arrays;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> numberToFrequency = new HashMap<>();

        for (int num : nums) {
            numberToFrequency.merge(num, 1, Integer::sum);
        }

        numberToFrequency.forEach((key, value) -> {
            pq.offer(new int[]{key, value});
            if (pq.size() > k) pq.poll();
        });

        int count = 0;
        while (!pq.isEmpty()) {
            result[count++] = pq.poll()[0];
        }

        return result;
    }

}
