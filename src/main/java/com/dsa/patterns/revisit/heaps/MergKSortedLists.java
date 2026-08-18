package com.dsa.patterns.revisit.heaps;

import com.dsa.patterns.heaps.MergeKSortedLists;
import com.dsa.patterns.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        System.out.println(mergeKSortedLists.mergeKLists(new ListNode[]{}));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode list : lists) {
            if (list != null) minHeap.offer(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            tail.next = min;
            tail = tail.next;

            if (min.next != null) minHeap.offer(min.next);
        }

        return dummy.next;
    }

}
