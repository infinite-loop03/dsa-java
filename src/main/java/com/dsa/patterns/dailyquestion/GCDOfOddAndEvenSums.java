package com.dsa.patterns.dailyquestion;

public class GCDOfOddAndEvenSums {

    public static void main(String[] args) {
        GCDOfOddAndEvenSums gcdOfOddAndEvenSums = new GCDOfOddAndEvenSums();
        System.out.println(gcdOfOddAndEvenSums.gcdOfOddEvenSums(99));
    }

    public int gcdOfOddEvenSums(int n) {
        int oddSum = n * n;
        int evenSum = n * (n + 1);

        while (oddSum != 0) {
            int temp = oddSum;
            oddSum = evenSum % oddSum;
            evenSum = temp;
        }
        return evenSum;
    }

}
