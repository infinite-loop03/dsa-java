package com.dsa.patterns.revision.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<int[]> deque;

    static void main() {

    }

    public MinStack() {
        deque = new ArrayDeque<>();
    }

    public void push(int value) {
        int currMin = Integer.MAX_VALUE;
        if (deque.isEmpty()) {
            currMin = value;
        }
        deque.push(new int[]{value, currMin});
    }

    public void pop() {
        if (!deque.isEmpty()) deque.pop();
    }

    public int top() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peek()[0];
    }

    public int getMin() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peek()[1];
    }
}
