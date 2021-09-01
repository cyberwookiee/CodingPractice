package com.brymanco.lists.impl;

import java.util.List;
import com.brymanco.lists.IListIterator;

class ListIterator<T extends Comparable<T>> implements IListIterator<T> {

    public ListIterator(final List<T> list) {
        this.pos = 0;
        this.list = list;
    }

    private int pos;

    private final List<T> list;

    @Override
    public boolean isDepleted() {
        return pos == list.size();
    }

    @Override
    public T next() {
        if (pos == list.size()) {
            throw new IllegalStateException();
        }
        return list.get(pos++);
    }

    @Override
    public T peek() {
        if (pos == list.size()) {
            throw new IllegalStateException();
        }
        return list.get(pos);
    }

    @Override
    public boolean hasNext() {
        return pos < list.size();
    }

}
