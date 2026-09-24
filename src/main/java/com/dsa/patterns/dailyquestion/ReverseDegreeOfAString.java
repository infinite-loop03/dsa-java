package com.dsa.patterns.dailyquestion;

public class ReverseDegreeOfAString {

    public static void main(String[] args) {
        ReverseDegreeOfAString reverseDegreeOfAString = new ReverseDegreeOfAString();
        String s = "zaza";
        System.out.println(reverseDegreeOfAString.reverseDegree(s));
    }

    public int reverseDegree(String s) {
        int index = 1;
        int reverseDegree = 0;
        for (char c : s.toCharArray()) {
            reverseDegree += index * ('z' - c + 1);
            index++;
        }
        return reverseDegree;
    }
}
