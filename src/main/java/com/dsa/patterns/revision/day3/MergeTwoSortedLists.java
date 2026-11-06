package com.dsa.patterns.revision.day3;

import com.dsa.patterns.linkedlist.ListNode;

public class MergeTwoSortedLists {

    static void main() {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode combined = dummy.next;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                dummy.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                dummy.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            dummy = dummy.next;
        }

        if (list1 != null) dummy.next = list1;
        else dummy.next = list2;

        return combined;
    }
}
