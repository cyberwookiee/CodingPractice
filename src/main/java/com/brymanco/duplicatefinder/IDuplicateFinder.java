package com.brymanco.duplicatefinder;

public interface IDuplicateFinder {

    /**
     * Return the single duplicate in a list
     *
     * @param list
     * @return
     */
    long findDuplicate(final Integer[] list);

}
