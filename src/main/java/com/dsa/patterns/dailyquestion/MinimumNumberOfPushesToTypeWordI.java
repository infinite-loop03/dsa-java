package com.dsa.patterns.dailyquestion;

public class MinimumNumberOfPushesToTypeWordI {

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordI minimumNumberOfPushesToTypeWordI = new MinimumNumberOfPushesToTypeWordI();
        System.out.println(minimumNumberOfPushesToTypeWordI.minimumPushes("abhrlngxyjkezwcm"));
    }

    public int minimumPushes(String word) {

        int n = word.length();
        int m = (n - 1) / 8 + 1;
        return m * (m - 1) * 4 + (n - (m - 1) * 8) * m;

    }
}
