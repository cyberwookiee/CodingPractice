package com.brymanco.lists;

import java.util.Iterator;

public interface IListIterator<T extends Comparable<T>> extends Iterator<T> {

    boolean isDepleted();

    T peek();

}
