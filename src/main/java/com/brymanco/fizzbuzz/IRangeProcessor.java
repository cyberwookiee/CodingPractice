package com.brymanco.fizzbuzz;

import java.util.function.Consumer;
import java.util.function.IntFunction;

public interface IRangeProcessor {

    /**
     * given the start and end positions of a range, map those values and pass
     * each values to a consumer
     *
     * @param <T>
     * @param start
     * @param end
     * @param mapper
     * @param consumer
     */
    <T> void processRange(int start, int end, IntFunction<T> mapper, Consumer<T> consumer);
}
