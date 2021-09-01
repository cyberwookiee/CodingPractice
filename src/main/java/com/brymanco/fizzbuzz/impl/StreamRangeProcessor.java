package com.brymanco.fizzbuzz.impl;

import com.brymanco.fizzbuzz.IRangeProcessor;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class StreamRangeProcessor implements IRangeProcessor {

    @Override
    public <T> void processRange(int start, int end, IntFunction<T> mapper, Consumer<T> consumer) {
        IntStream.rangeClosed(start, end)
                .mapToObj(mapper)
                .forEach(consumer);
    }
}
