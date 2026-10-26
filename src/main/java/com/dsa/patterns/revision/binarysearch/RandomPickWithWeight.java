package com.dsa.patterns.revision.binarysearch;

import java.util.*;

public class RandomPickWithWeight {

    static void main() {
        int[] w = {1, 3};
        Solution randomPickWithWeight = new Solution(w);
        System.out.println(randomPickWithWeight.pickIndex());
    }

    static class Solution {
        List<Integer> prefixSum;
        int total;
        public Solution(int[] w) {
            prefixSum = new ArrayList<>();
            total = 0;

            for (int weight : w) {
                total += weight;
                prefixSum.add(total);
            }
        }

        public int pickIndex() {
            Random random = new Random();
            int target = random.nextInt(total) + 1;

            int low = 0;
            int high = prefixSum.size();

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (prefixSum.get(mid) < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}


