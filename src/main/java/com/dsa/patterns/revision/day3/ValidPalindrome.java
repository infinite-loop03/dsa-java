package com.dsa.patterns.revision.day3;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "race a car";
        System.out.println(validPalindrome.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (Character.isLetterOrDigit(s.charAt(left)) && Character.isLetterOrDigit(s.charAt(right))) {
                if (s.charAt(left) != s.charAt(right)) return false;
                left++;
                right--;
            } else if (Character.isLetterOrDigit(s.charAt(left))) {
                right--;
            } else {
                left++;
            }
        }
        return true;
    }
}
