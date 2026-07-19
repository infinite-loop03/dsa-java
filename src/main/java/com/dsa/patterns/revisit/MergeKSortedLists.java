package com.dsa.patterns.revisit;

import com.dsa.patterns.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] lists = {listNode1, listNode2, listNode3};

        ListNode merged = mergeKSortedLists.mergeKLists(lists);
        ListNode.printList(merged);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (ListNode node : lists) {
            pq.offer(node);
        }

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if (min.next != null) pq.offer(min.next);
        }

        return dummy.next;
    }
}
