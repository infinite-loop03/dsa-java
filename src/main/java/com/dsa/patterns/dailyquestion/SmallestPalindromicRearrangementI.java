package com.dsa.patterns.dailyquestion;

public class SmallestPalindromicRearrangementI {

    public static void main(String[] args) {
        SmallestPalindromicRearrangementI smallestPalindromicRearrangementI = new SmallestPalindromicRearrangementI();
        System.out.println(smallestPalindromicRearrangementI.smallestPalindrome("daccad"));
    }

    public String smallestPalindrome(String s) {
        int[] freqMap = new int[26];

        for (char c : s.toCharArray()) {
            freqMap[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        sb.setLength(s.length());

        int left = 0;
        int right = s.length() - 1;

        for (int i = 0; i < 26; i++) {
            while (freqMap[i] > 1) {
                sb.setCharAt(left, (char)('a' + i));
                sb.setCharAt(right, (char)('a' + i));
                left++;
                right--;
                freqMap[i] -= 2;
            }
        }

        if (s.length() % 2 != 0) {
            char mid = ' ';
            for (int i = 0; i < 26; i++) {
                if (freqMap[i] > 0) {
                    mid = (char)('a' + i);
                    break;
                }
            }
            sb.setCharAt(left, mid);
        }
        return sb.toString();
    }

}
