package com.brymanco.duplicatefinder.impl;

import com.brymanco.duplicatefinder.IDuplicateFinder;

public class HashSortDuplicateFinder implements IDuplicateFinder {

    @Override
    public long findDuplicate(Integer[] list) {
        int index = 0;

        while (index < list.length) {

            final int numberAtIndex = list[index];
            final int correctIndex = numberAtIndex - 1;
            final int numberAtCorrectIndex = list[correctIndex];

            if (numberAtIndex != numberAtCorrectIndex) {
                list[index] = numberAtCorrectIndex;
                list[correctIndex] = numberAtIndex;
            } else if (index != correctIndex) {
                return numberAtIndex;
            } else {
                index++;
            }

        }
        return -1;

    }

}
