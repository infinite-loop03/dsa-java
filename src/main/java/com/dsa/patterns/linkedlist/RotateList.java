package com.dsa.patterns.linkedlist;

public class RotateList {

    static void main() {
        RotateList rotateList = new RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode rotated = rotateList.rotateRight(head, 2);
        while (rotated != null) {
            System.out.print(rotated.val + " -> ");
            rotated = rotated.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0) return head;

        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

}
