package com.dsa.patterns.revision.day3;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        int[] people = {1, 2};
        int limit = 3;
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
