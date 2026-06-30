package com.dsa.patterns.dailyquestion;

public class NumberOfSubstringsContainingAllThreeCharacters {

    public static void main(String[] args) {
        NumberOfSubstringsContainingAllThreeCharacters numberOfSubstringsContainingAllThreeCharacters = new NumberOfSubstringsContainingAllThreeCharacters();
        String s = "abc";
        System.out.println(numberOfSubstringsContainingAllThreeCharacters.numberOfSubstrings(s));
    }

    public int numberOfSubstrings(String s) {
        int start = 0;
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int totalCount = 0;

        for (int end = 0; end < s.length(); end++) {
            if (s.charAt(end) == 'a') aCount++;
            if (s.charAt(end) == 'b') bCount++;
            if (s.charAt(end) == 'c') cCount++;
            while (aCount > 0 && bCount > 0 && cCount > 0) {
                totalCount += s.length() - end;
                if (s.charAt(start) == 'a') aCount--;
                if (s.charAt(start) == 'b') bCount--;
                if (s.charAt(start) == 'c') cCount--;
                start++;
            }
        }
        return totalCount;
    }
}
