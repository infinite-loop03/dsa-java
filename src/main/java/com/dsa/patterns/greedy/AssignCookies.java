package com.dsa.patterns.greedy;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        System.out.println(assignCookies.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int gCount = 0;
        int sCount = 0;

        while (gCount < g.length && sCount < s.length) {
            if (g[gCount] <= s[sCount]) {
                count++;
                gCount++;
            }
            sCount++;
        }
        return count;
    }
}
