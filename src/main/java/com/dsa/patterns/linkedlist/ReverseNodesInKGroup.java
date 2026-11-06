package com.dsa.patterns.linkedlist;

public class ReverseNodesInKGroup {

    static void main() {
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = reverseNodesInKGroup.reverseKGroup(head, 2);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode groupBefore = dummy;
        ListNode groupEnd = getKthNode(groupBefore, k);

        while (groupEnd != null) {
            ListNode groupStart = groupBefore.next;
            ListNode groupAfter = groupEnd.next;

            groupEnd.next = null;
            groupBefore.next = reverse(groupStart);
            groupStart.next = groupAfter;

            groupBefore = groupStart;
            groupEnd = getKthNode(groupBefore, k);
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    private ListNode reverse(ListNode head) {
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
