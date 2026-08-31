package com.dsa.patterns.dailyquestion;

import com.dsa.patterns.linkedlist.ListNode;

import java.util.Arrays;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    public static void main(String[] args) {
        FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints findTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next.next.next.next = new ListNode(7);

        System.out.println(Arrays.toString(findTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.nodesBetweenCriticalPoints(listNode)));
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[]{-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return result;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        int left = -1;
        int right = -1;
        int index = 1;
        int min = Integer.MAX_VALUE;

        while (next != null) {
            if (curr.val < prev.val && curr.val < next.val) {
                if (left == -1) left = index;
                if (right != -1) min = Math.min(index - right, min);
                right = index;
            } else if (curr.val > prev.val && curr.val > next.val) {
                if (left == -1) left = index;
                if (right != -1) min = Math.min(index - right, min);
                right = index;
            }
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }

        if (left == right) return result;

        return new int[]{min, right - left};
    }
}
