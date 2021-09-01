package com.brymanco.linkedlists;

public class LinkedListAdder {

    public static LinkedList<Integer> add(LinkedList<Integer> first, LinkedList<Integer> second) {

        LinkedListNode<Integer> firstPlace = first.getHead();

        LinkedListNode<Integer> secondPlace = first.getHead();

        LinkedListNode<Integer> answerHead = null;

        LinkedListNode<Integer> answerPlace = null;

        int carry = 0;

        while (firstPlace != null || secondPlace != null) {

            if (answerPlace == null) {
                answerPlace = new LinkedListNode<>();
                answerHead = answerPlace;
            } else {
                answerPlace.next = new LinkedListNode<>();
                answerPlace = answerPlace.next;
            }

            answerPlace.data = carry;

            if (firstPlace != null) {
                answerPlace.data += firstPlace.data;
                firstPlace = firstPlace.next;
            }

            if (secondPlace != null) {
                answerPlace.data += secondPlace.data;
                secondPlace = secondPlace.next;
            }

            carry = answerPlace.data > 9 ? 1 : 0;

            answerPlace.data %= 10;

        }

        return new LinkedList<>(answerHead);

    }

}
