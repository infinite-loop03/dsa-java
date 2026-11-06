package com.dsa.patterns.revision.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    static void main() {
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        n1.random = n3;
        n2.random = n1;
        n3.random = n2;


        Node copiedHead = copyListWithRandomPointer.copyRandomList(n1);

        System.out.println("Original List:");
        printList(n1);

        System.out.println("\nCopied List:");
        printList(copiedHead);
    }

    static void printList(Node head) {

        Node curr = head;

        while (curr != null) {

            int randomVal =
                    (curr.random != null)
                            ? curr.random.val
                            : -1;

            System.out.println(
                    "Node = " + curr.val +
                            ", Random = " + randomVal
            );

            curr = curr.next;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> originalToCopy = new HashMap<>();
        Node current = head;

        while (current != null) {
            Node copy = getOrCreateCopy(current, originalToCopy);
            copy.next = getOrCreateCopy(current.next, originalToCopy);
            copy.random = getOrCreateCopy(current.random, originalToCopy);
            current = current.next;
        }

        return originalToCopy.get(head);
    }

    private Node getOrCreateCopy(Node original, Map<Node, Node> originalToCopy) {
        if (original == null) {
            return null;
        }
        return originalToCopy.computeIfAbsent(original, node -> new Node(node.val));
    }

    public Node copyRandomListByInterweaving(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        Node copyHead = head.next;
        current = head;
        while (current != null) {
            Node copy = current.next;
            current.next = copy.next;
            copy.next = copy.next != null ? copy.next.next : null;
            current = current.next;
        }

        return copyHead;
    }

    static final class Node {
        private final int val;
        private Node next;
        private Node random;

        Node(int val) {
            this.val = val;
        }
    }
}
