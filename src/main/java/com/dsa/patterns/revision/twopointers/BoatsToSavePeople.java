package com.dsa.patterns.revision.twopointers;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(boatsToSavePeople.numRescueBoats(people, limit));
        System.out.println(boatsToSavePeople.numOfRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        int minimumBoats = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            minimumBoats++;
            right--;

        }

        return minimumBoats;
    }

    public int numOfRescueBoats(int[] people, int limit) {
        int[] sorted = countingSort(people, limit);

        int i = 0, j = sorted.length - 1;
        int boats = 0;

        while (i <= j) {
            if (sorted[i] + sorted[j] <= limit) {
                i++;
            }
            j--;
            boats++;
        }

        return boats;
    }

    private int[] countingSort(int[] people, int limit) {
        int[] count = new int[limit + 1];
        for (int weight : people) {
            count[weight]++;
        }

        int[] sorted = new int[people.length];
        int index = 0;
        for (int weight = 1; weight <= limit; weight++) {
            while (count[weight] > 0) {
                sorted[index++] = weight;
                count[weight]--;
            }
        }

        return sorted;
    }

}
