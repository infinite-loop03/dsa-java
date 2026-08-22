package com.dsa.patterns.dailyquestion;

public class CheckDivisibilityByDigitSumAndProduct {

    public static void main(String[] args) {
        CheckDivisibilityByDigitSumAndProduct checkDivisibilityByDigitSumAndProduct = new CheckDivisibilityByDigitSumAndProduct();
        int n = 0;
        System.out.println(checkDivisibilityByDigitSumAndProduct.checkDivisibility(n));
    }

    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int num = n;

        while (n != 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n = n / 10;
        }

        return num % (sum + product) == 0;
    }

}
