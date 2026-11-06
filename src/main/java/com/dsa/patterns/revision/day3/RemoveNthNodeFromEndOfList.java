package com.dsa.patterns.revision.day3;

import com.dsa.patterns.linkedlist.ListNode;

public class RemoveNthNodeFromEndOfList {

    static void main() {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        ListNode removedNthFromEnd = removeNthNodeFromEndOfList.removeNthFromEnd(node1, 1);
        while (removedNthFromEnd != null) {
            System.out.println(removedNthFromEnd.val);
            removedNthFromEnd = removedNthFromEnd.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
