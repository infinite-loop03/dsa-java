package com.dsa.patterns.revision.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static void main(String[] args) {
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int[] fruits = {1, 0, 1, 4, 1, 4, 1, 2, 3};
        System.out.println(fruitIntoBaskets.totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;

        for (int fruit : fruits) {
            count.merge(fruit, 1, Integer::sum);

            if (count.size() > 2) {
                int leftType = fruits[left];
                if (count.merge(leftType, -1, Integer::sum) == 0) {
                    count.remove(leftType);
                }
                left++;
            }
        }
        return fruits.length - left;
    }
}
