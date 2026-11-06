package com.dsa.patterns.revision.linkedlist;

import com.dsa.patterns.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    static void main() {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode result = mergeKSortedLists.mergeKLists(new ListNode[]{l1, l2, l3});
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Math.max(1, lists.length), Comparator.comparingInt(a -> a.val));
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (ListNode list : lists) {
            if (list != null) pq.offer(list);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }

    public ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        if (lists.length == 0) return null;

        for (int step = 1; step < lists.length; step *= 2) {
            for (int i = 0; i + step < lists.length; i += step * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + step]);
            }
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
