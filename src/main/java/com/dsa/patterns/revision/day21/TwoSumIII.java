package com.dsa.patterns.revision.day21;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {

    static void main() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(3);
        twoSum.add(1);
        twoSum.add(5);
        System.out.println(twoSum.find(4));
    }

    static class TwoSum {
        Map<Integer, Integer> numberToFrequency;

        public TwoSum() {
            numberToFrequency = new HashMap<>();
        }

        void add(int num) {
            numberToFrequency.merge(num, 0, Integer::sum);
        }

        boolean find(int num) {
            for (Map.Entry<Integer, Integer> entry : numberToFrequency.entrySet()) {
                int pair1 = entry.getKey();
                int count = entry.getValue();
                int pair2 = num - pair1;

                if ((pair1 == pair2 && count > 1) || (pair1 != pair2 && numberToFrequency.containsKey(pair2))) {
                    return true;
                }
            }
            return false;
        }
    }
}
