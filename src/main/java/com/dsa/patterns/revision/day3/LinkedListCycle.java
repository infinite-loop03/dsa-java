package com.dsa.patterns.revision.day3;

import com.dsa.patterns.linkedlist.ListNode;

public class LinkedListCycle {

    static void main() {
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2);
        four.next = two;
        ListNode head = new ListNode(1, two);
        two.next = head;

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        System.out.println(linkedListCycle.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
