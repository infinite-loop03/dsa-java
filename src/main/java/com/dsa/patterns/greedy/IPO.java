package com.dsa.patterns.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    public static void main(String[] args) {
        IPO ipo = new IPO();
        int[] profits = {1, 2, 3};
        int[] capital = {1, 1, 2};
        int k = 1, w = 2;
        System.out.println(ipo.findMaximizedCapital(k, w, profits, capital));
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] projects = new int[capital.length][2];

        for (int i = 0; i < capital.length; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, Comparator.comparingInt(project -> project[0]));
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (k-- > 0) {
            while (i < projects.length && projects[i][0] <= w) {
                pq.offer(projects[i][1]);
                i++;
            }

            if (pq.isEmpty()) break;

            w += pq.poll();

        }
        return w;
    }

}
