package com.brymanco.linkedlists;

public class LinkedList<T> {

    private final LinkedListNode<T> head;

    public LinkedList(final LinkedListNode<T> head) {
        this.head = head;
    }

    public LinkedListNode<T> getHead() {
        return head;
    }

    LinkedListNode nthToLast(int n) {

        if (n < 1) {
            return null;
        }

        LinkedListNode p1 = head, p2 = head;

        for (int ii = 0; ii < n - 1; ii++) {
            if (p2 == null) {
                return null;
            }

            p2 = p2.getNext();

        }

        while (p2.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return p1;

    }

}
