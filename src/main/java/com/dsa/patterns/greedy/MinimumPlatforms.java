package com.dsa.patterns.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumPlatforms {

    public static void main(String[] args) {
        MinimumPlatforms minimumPlatforms = new MinimumPlatforms();
        int[] arr = {1, 3, 4};
        int[] dep = {2, 5, 10};
        System.out.println(minimumPlatforms.minPlatform2(arr, dep));
    }

    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;

        int[][] trains = new int[n][2];

        for (int i = 0; i < n; i++) {
            trains[i][0] = arr[i];
            trains[i][1] = dep[i];
        }

        Arrays.sort(trains, Comparator.comparingInt(train -> train[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] train : trains) {
            if (!pq.isEmpty() && pq.peek() < train[0]) {
                pq.poll();
            }
            pq.offer(train[1]);
        }

        return pq.size();
    }

    public int minPlatform2(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 1;

        int i = 0;
        int j = 0;

        while (i < arr.length) {
            while (dep[j] < arr[i]) {
                j++;
            }
            platforms = Math.max(platforms, i - j + 1);
            i++;
        }

        return platforms;

    }

}
