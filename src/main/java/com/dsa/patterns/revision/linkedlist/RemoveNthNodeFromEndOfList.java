package com.dsa.patterns.revision.linkedlist;

import com.dsa.patterns.linkedlist.ListNode;

public class RemoveNthNodeFromEndOfList {

    static void main() {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        ListNode removedNthFromEnd = removeNthNodeFromEndOfList.removeNthFromEnd(node1, 1);
        while (removedNthFromEnd != null) {
            System.out.println(removedNthFromEnd.val);
            removedNthFromEnd = removedNthFromEnd.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <=n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
