package com.dsa.patterns.revision.linkedlist;

import com.dsa.patterns.linkedlist.ListNode;

public class MergeTwoSortedLists {

    static void main() {
        com.dsa.patterns.linkedlist.MergeTwoSortedLists mergeTwoSortedLists = new com.dsa.patterns.linkedlist.MergeTwoSortedLists();
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2, node4);
        ListNode node1 = new ListNode(1, node2);
        ListNode list1 =node1;
        System.out.print("List 1 ::: ");
        while (list1 !=null) {
            System.out.print(list1.val + " -> ");
            list1 = list1.next;
        }
        list1 = node1;

        ListNode anotherNode4 = new ListNode(4);
        ListNode node3 = new ListNode(3, anotherNode4);
        ListNode anotherNode1 = new ListNode(1, node3);
        ListNode list2 = anotherNode1;
        System.out.print("List 2 ::: ");
        while (list2 !=null) {
            System.out.print(list2.val + " -> ");
            list2 = list2.next;
        }
        list2 = anotherNode1;

        ListNode merged = mergeTwoSortedLists.mergeTwoLists(list1, list2);
        System.out.print("Merged ::: ");
        while (merged != null) {
            System.out.print(merged.val + " -> ");
            merged = merged.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode merged = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                dummy.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        while (list1 != null) {
            dummy.next = new ListNode(list1.val);
            list1 = list1.next;
            dummy = dummy.next;
        }

        while (list2 != null) {
            dummy.next = new ListNode(list2.val);
            list2 = list2.next;
            dummy = dummy.next;
        }
        return merged.next;
    }
}
