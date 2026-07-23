package com.dsa.patterns.dailyquestion;

public class NumberOfUniqueXORTripletsI {

    public static void main(String[] args) {
        NumberOfUniqueXORTripletsI numberOfUniqueXORTripletsI = new NumberOfUniqueXORTripletsI();
        int[] nums = {1, 2, 3};
        System.out.println(numberOfUniqueXORTripletsI.uniqueXorTriplets(nums));
    }

    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int ans = 1;
        while (ans <= n) {
            ans <<= 1;
        }
        return ans;
    }
}
