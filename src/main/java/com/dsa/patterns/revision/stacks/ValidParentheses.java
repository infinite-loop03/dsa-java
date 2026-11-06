package com.dsa.patterns.revision.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    static void main() {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "()(";
        System.out.println(validParentheses.isValid(s));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }

        return stack.isEmpty();
    }
}
