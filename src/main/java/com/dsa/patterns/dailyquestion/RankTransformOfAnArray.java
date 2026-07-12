package com.dsa.patterns.dailyquestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray {

    public static void main(String[] args) {
        RankTransformOfAnArray rankTransformOfAnArray = new RankTransformOfAnArray();
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println(Arrays.toString(rankTransformOfAnArray.arrayRankTransform(arr)));
    }

    public int[] arrayRankTransform(int[] arr) {
        int[] res = Arrays.copyOf(arr, arr.length);

        Arrays.sort(res);
        Map<Integer, Integer> numberToRank = new HashMap<>();

        int rank = 1;

        for (int num : res) {
            if (!numberToRank.containsKey(num)) {
                numberToRank.put(num, rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            res[i] = numberToRank.get(arr[i]);
        }

        return res;
    }
}
