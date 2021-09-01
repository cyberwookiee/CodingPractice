package com.brymanco.duplicatefinder.impl;

import com.brymanco.duplicatefinder.IDuplicateFinder;
import java.util.HashSet;
import java.util.Set;

public class HashSetDuplicateFinder implements IDuplicateFinder {

    @Override
    public long findDuplicate(Integer[] list) {
        final Set<Integer> vals = new HashSet<>();

        for (Integer ii : list) {
            if (vals.contains(ii)) {
                return ii;
            }
            vals.add(ii);
        }
        return -1;

    }

}
