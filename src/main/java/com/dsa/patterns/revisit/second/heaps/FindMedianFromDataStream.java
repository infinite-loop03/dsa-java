package com.dsa.patterns.revisit.second.heaps;

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

        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        void addNum(int num) {
            if (minHeap.isEmpty() || minHeap.peek() <= num) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }

            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        }

        double findMedian() {
            if (!minHeap.isEmpty() && minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            }

            if (!maxHeap.isEmpty() && maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }

            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

    }

}
