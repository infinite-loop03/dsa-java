package com.dsa.patterns.linkedlist;

public class ReverseLinkedListII {

    static void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = new ReverseLinkedListII().reverseBetween(head, 2, 4);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode before = dummy;
        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        ListNode reversedTail = before.next;
        ListNode previous = null;
        ListNode current = reversedTail;

        for (int i = left; i <= right; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        before.next = previous;
        reversedTail.next = current;

        return dummy.next;
    }
}
