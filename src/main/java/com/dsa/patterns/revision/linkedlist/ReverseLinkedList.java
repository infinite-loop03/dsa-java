package com.dsa.patterns.revision.linkedlist;

import com.dsa.patterns.linkedlist.ListNode;

public class ReverseLinkedList {

    static void main() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode reversed = reverseLinkedList.reverseList(node1);
        while (reversed != null) {
            System.out.print(reversed.val);
            System.out.print(" -> ");
            reversed = reversed.next;
        }
        System.out.println("null");
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

}
