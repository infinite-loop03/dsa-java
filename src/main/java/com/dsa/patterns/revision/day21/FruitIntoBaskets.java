package com.dsa.patterns.revision.day21;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    static void main() {
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int[] fruits = {0, 1, 2, 2};
        System.out.println(fruitIntoBaskets.totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitCount = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < fruits.length) {
            fruitCount.merge(fruits[right], 1, Integer::sum);
            if (fruitCount.size() > 2) {
                if (fruitCount.merge(fruits[left], -1, Integer::sum) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }
            right++;
        }
        return right - left;
    }
}
