package com.dsa.patterns.greedy;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        int[] people = {3, 5, 3, 4};
        int limit = 5;
        System.out.println(boatsToSavePeople.numRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int numOfBoats = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            numOfBoats++;
        }
        return numOfBoats;
    }
}
