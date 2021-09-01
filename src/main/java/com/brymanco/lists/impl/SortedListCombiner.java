package com.brymanco.lists.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import com.brymanco.lists.ISortedListCombiner;

public class SortedListCombiner<T extends Comparable<T>> implements ISortedListCombiner<T> {

    @Override
    public List<T> combine(final List<T> list1, final List<T> list2) {
        final List<T> combined = new ArrayList<>(list1.size() + list2.size());

        int pos1 = 0;
        int pos2 = 0;

        while (true) {

            if (pos1 < list1.size() && pos2 < list2.size()) {
                final T el1 = list1.get(pos1);
                final T el2 = list2.get(pos2);

                final int comparison = el1.compareTo(el2);

                if (comparison < 0) {
                    pos1++;
                    combined.add(el1);
                } else if (comparison > 0) {
                    pos2++;
                    combined.add(el2);
                } else {
                    pos1++;
                    combined.add(el1);
                    pos2++;
                    combined.add(el2);
                }

            } else if (pos1 < list1.size()) {
                combined.addAll(list1.subList(pos1, list1.size() - 1));
                break;
            } else if (pos2 < list2.size()) {
                combined.addAll(list2.subList(pos2, list2.size() - 1));
                break;
            } else {
                break;
            }

        }

        return combined;
    }

    @Override
    public List<T> combine(final List<List<T>> lists) {
        final List<T> combined = new ArrayList<>(
                lists.stream()
                        .map(l -> l.size())
                        .reduce(0, Integer::sum));

        final List<ListIterator<T>> iterators = lists
                .stream()
                .map(l -> new ListIterator<T>(l))
                .collect(Collectors.toList());

        final PriorityQueue<T> candidates = new PriorityQueue<>();

        while (true) {
            for (final ListIterator<T> iterator : iterators) {
                if (!iterator.isDepleted()
                        && (candidates.isEmpty() || iterator.peek().compareTo(candidates.peek()) < 0)) {
                    candidates.add(iterator.next());
                }
            }

            if (candidates.isEmpty()) {
                break;
            }

            combined.add(candidates.poll());
        }

        return combined;

    }

}
