package com.dsa.patterns.dailyquestion;

public class MaximumProductOfTwoDigits {

    public static void main(String[] args) {
        MaximumProductOfTwoDigits maximumProductOfTwoDigits = new MaximumProductOfTwoDigits();
        System.out.println(maximumProductOfTwoDigits.maxProduct(Integer.MAX_VALUE));
    }

    public int maxProduct(int n) {
        int first = 0;
        int second = 0;

        while (n > 0) {
            int x = n % 10;
            if (x > first) {
                second = first;
                first = x;
            } else if (x > second) {
                second = x;
            }
            n = n / 10;
        }
        return first * second;
    }
}
