package com.dsa.patterns.revision.day21;

import java.util.Arrays;

public class BoatsToSavePeople {

    static void main() {
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        int[] people = {1, 2};
        int limit = 3;
        System.out.println(boatsToSavePeople.numRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int numOfBoats = 0;

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
