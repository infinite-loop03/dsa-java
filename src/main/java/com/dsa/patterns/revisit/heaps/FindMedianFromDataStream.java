package com.dsa.patterns.revisit.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder {

        private final PriorityQueue<Integer> small;
        private final PriorityQueue<Integer> large;

        MedianFinder() {
            small = new PriorityQueue<>();
            large = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            if (small.isEmpty() || small.peek() <= num) {
                small.offer(num);
            } else {
                large.offer(num);
            }

            if (small.size() > large.size() + 1) large.offer(small.poll());
            if (large.size() > small.size() + 1) small.offer(large.poll());
        }

        public double findMedian() {
            if (!small.isEmpty() && small.size() > large.size()) {
                return small.peek();
            }

            if (!large.isEmpty() && large.size() > small.size()) {
                return large.peek();
            }

            return (large.peek() + small.peek()) / 2.0;
        }
    }

}
