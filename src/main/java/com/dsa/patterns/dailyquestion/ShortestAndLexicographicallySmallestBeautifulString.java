package com.dsa.patterns.dailyquestion;

public class ShortestAndLexicographicallySmallestBeautifulString {

    public static void main(String[] args) {
        ShortestAndLexicographicallySmallestBeautifulString shortestAndLexicographicallySmallestBeautifulString = new ShortestAndLexicographicallySmallestBeautifulString();
        String s = "100011001";
        System.out.println(shortestAndLexicographicallySmallestBeautifulString.shortestBeautifulSubstring(s, 3));
    }

    public String shortestBeautifulSubstring(String s, int k) {
        int total = 0;

        for (int i = 0; i < s.length(); i++) total += s.charAt(i) - '0';
        if (total < k) return "";

        int start = 0;
        int count = 0;

        String min = s;

        for (int end = 0; end < s.length(); end++) {
            count += s.charAt(end) - '0';
            while (count > k || s.charAt(start) == '0') {
                count -= s.charAt(start++) - '0';
            }
            if (count == k) {
                String sub = s.substring(start, end + 1);
                if (sub.length() < min.length() ||
                        (sub.length() == min.length() && sub.compareTo(min) < 0)) {
                    min = sub;
                }
            }
        }
        return min;
    }
}
