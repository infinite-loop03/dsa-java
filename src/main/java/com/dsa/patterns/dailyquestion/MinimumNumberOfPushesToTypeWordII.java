package com.dsa.patterns.dailyquestion;

import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWordII {

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordII minimumNumberOfPushesToTypeWordII = new MinimumNumberOfPushesToTypeWordII();
        System.out.println(minimumNumberOfPushesToTypeWordII.minimumPushes("aabbccddeeffgghhiiiiii"));
    }

    public int minimumPushes(String word) {
        int[] freqMap = new int[26];

        for (char c : word.toCharArray()) {
            freqMap[c - 'a']++;
        }

        Arrays.sort(freqMap);

        int minPushes = 0;

        for (int i = 25; i >= 0; i--) {
            minPushes += freqMap[i] * ((25 - i) / 8 + 1);
        }

        return minPushes;
    }
}
