package com.dsa.patterns.revision.twopointers;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "0P";
        System.out.println(validPalindrome.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        while (left < right) {
            if (Character.isLetterOrDigit(s.charAt(left)) && Character.isLetterOrDigit(s.charAt(right))) {
                if (s.charAt(left) == s.charAt(right)) {
                    right--;
                    left++;
                } else return false;
            } else if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
        }
        return true;
    }
}
