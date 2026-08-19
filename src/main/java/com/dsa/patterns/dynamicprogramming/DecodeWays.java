package com.dsa.patterns.dynamicprogramming;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        String s = "06";
        System.out.println(decodeWays.numDecodings(s));
    }

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = 0;

            if (s.charAt(i - 1) != '0') curr += prev1;

            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) curr += prev2;

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
