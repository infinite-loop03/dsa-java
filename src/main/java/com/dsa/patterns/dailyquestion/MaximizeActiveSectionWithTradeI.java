package com.dsa.patterns.dailyquestion;

public class MaximizeActiveSectionWithTradeI {

    public static void main(String[] args) {
        MaximizeActiveSectionWithTradeI maximizeActiveSectionWithTradeI = new MaximizeActiveSectionWithTradeI();
        System.out.println(maximizeActiveSectionWithTradeI.maxActiveSectionsAfterTrade("01"));
    }

    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int oneCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') oneCount++;
        }

        int i = 0;
        int bestGain = 0;
        int prev = Integer.MIN_VALUE;
        int cur;

        while (i < n) {
            int start = i;
            while (i < n && s.charAt(i) == s.charAt(start)) i++;
            if (s.charAt(start) == '0') {
                cur = i - start;
                if (prev != Integer.MIN_VALUE) {
                    bestGain = Math.max(bestGain, prev + cur);
                }
                prev = cur;
            }
        }

        return oneCount + bestGain;
    }
}
