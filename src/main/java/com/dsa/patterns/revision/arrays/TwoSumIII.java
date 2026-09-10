package com.dsa.patterns.revision.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        obj.add(1);
        obj.add(3);
        obj.add(5);

        boolean param2 = obj.find(4);
        System.out.println("Found sum of 4: " + param2);

        param2 = obj.find(7);
        System.out.println("Found sum of 7: " + param2);
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


