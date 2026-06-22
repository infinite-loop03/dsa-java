package com.dsa.patterns.dailyquestion;

public class MaximumNumberOfBalloons {

    public static void main(String[] args) {
        MaximumNumberOfBalloons maximumNumberOfBalloons = new MaximumNumberOfBalloons();
        String text = "balloon";
        System.out.println(maximumNumberOfBalloons.maxNumberOfBalloons(text));
    }

    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }
        freq['l' - 'a'] /= 2;
        freq['o' - 'a'] /= 2;

        char[] balloonChars = {'b', 'a', 'l', 'o', 'n'};

        int minFreq = Integer.MAX_VALUE;

        for (char ballonChar : balloonChars) {
            minFreq = Math.min(minFreq, freq[ballonChar - 'a']);
        }

        return minFreq;
    }
}
