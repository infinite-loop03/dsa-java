package com.dsa.patterns.dailyquestion;

public class MaximumNestingDepthOfTheParentheses {

    public static void main(String[] args) {
        MaximumNestingDepthOfTheParentheses maximumNestingDepthOfTheParentheses = new MaximumNestingDepthOfTheParentheses();
        String s = "()(())((()()))";
        System.out.println(maximumNestingDepthOfTheParentheses.maxDepth(s));
    }

    public int maxDepth(String s) {
        int parenthesesCount = 0;
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                parenthesesCount++;
                maxDepth = Math.max(maxDepth, parenthesesCount);
            } else if (c == ')') {
                parenthesesCount--;
            }
        }
        return maxDepth;
    }
}
