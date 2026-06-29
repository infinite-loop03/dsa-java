package com.dsa.patterns.dailyquestion;

public class NumberOfStringsThatAppearAsSubstringsInWord {

    public static void main(String[] args) {
        NumberOfStringsThatAppearAsSubstringsInWord numberOfStringsThatAppearAsSubstringsInWord = new NumberOfStringsThatAppearAsSubstringsInWord();
        String[] patterns = {"a", "abc", "bc", "d"};
        String word = "abc";
        System.out.println(numberOfStringsThatAppearAsSubstringsInWord.numOfStrings(patterns, word));
    }

    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) count++;
        }

        return count;
    }
}
