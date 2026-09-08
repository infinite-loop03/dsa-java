package com.dsa.patterns.dailyquestion;

public class CountCommasInRange {

    public static void main(String[] args) {
        CountCommasInRange countCommasInRange = new CountCommasInRange();
        int n = 1002;
        System.out.println(countCommasInRange.countCommas(n));
    }

    public int countCommas(int n) {
        if (n < 1000) return 0;

        return n - 999;
    }

}
