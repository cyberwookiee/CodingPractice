package com.brymanco.lists;

import java.util.List;

public interface ISortedListCombiner<T extends Comparable<T>> {

    List<T> combine(List<T> list1, List<T> list2);

    List<T> combine(final List<List<T>> lists);

}
