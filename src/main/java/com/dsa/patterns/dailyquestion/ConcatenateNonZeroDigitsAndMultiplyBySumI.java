package com.dsa.patterns.dailyquestion;

public class ConcatenateNonZeroDigitsAndMultiplyBySumI {

    public static void main(String[] args) {
        ConcatenateNonZeroDigitsAndMultiplyBySumI concatenateNonZeroDigitsAndMultiplyBySumI = new ConcatenateNonZeroDigitsAndMultiplyBySumI();
        int n = Integer.MAX_VALUE;
        System.out.println(concatenateNonZeroDigitsAndMultiplyBySumI.sumAndMultiply(n));
    }

    public long sumAndMultiply(int n) {
        int num = 0;
        int multiplier = 1;
        int sum = 0;

        while (n != 0) {
            if (n % 10 != 0) {
                int digit = n % 10;
                num = digit * multiplier + num ;
                sum += digit;
                multiplier *= 10;
            }
            n /= 10;
        }
        return (long) num * sum;
    }
}
