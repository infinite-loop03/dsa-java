package com.dsa.patterns.linkedlist;

public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val);
            if(head.next!=null)
                System.out.print("->");

            head = head.next;
        }
    }
}
