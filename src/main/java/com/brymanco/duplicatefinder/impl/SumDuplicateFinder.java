package com.brymanco.duplicatefinder.impl;

import com.brymanco.duplicatefinder.IDuplicateFinder;

public class SumDuplicateFinder implements IDuplicateFinder {

    @Override
    public long findDuplicate(Integer[] list) {
        Long sum = 0L;

        for (Integer ii : list) {
            sum += ii;
        }

        return sum - ((list.length - 1) * ((list.length) / 2));

    }

}
