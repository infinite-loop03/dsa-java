package com.dsa.patterns.greedy;

import java.util.*;

public class ReorganizeString {

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("aba"));
    }

    public String reorganizeString(String s) {

        int[][] freqMap = new int[26][2];

        for (int i = 0; i < 26; i++) {
            freqMap[i][0] = 'a' + i;
        }

        for (char c : s.toCharArray()) {
            freqMap[c - 'a'][1]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int[] freq : freqMap) {
            if (freq[1] > 0) pq.offer(freq);
        }

        StringBuilder sb = new StringBuilder();
        int[] curr = null;
        if (!pq.isEmpty()) {
            curr = pq.poll();
            sb.append((char) curr[0]);
            curr[1]--;
        }

        while (!pq.isEmpty()) {
            int[] prev = curr;
            curr = pq.poll();

            sb.append((char) curr[0]);
            curr[1]--;

            if (prev[1] > 0) pq.offer(prev);
        }

        if (curr[1] > 0) return "";

        return sb.toString();
    }

}
