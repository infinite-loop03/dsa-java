package com.dsa.patterns.revisit.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class AssignCookies {

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
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
