package com.brymanco.fizzbuzz.impl;

import java.util.function.IntFunction;

public class FizzBuzzValueMapper implements IntFunction<String> {

    private final int buzz;

    private final int fizz;

    private final int fizzbuzz;

    public FizzBuzzValueMapper(int fizz, int buzz) {
        this.fizz = fizz;
        this.buzz = buzz;
        this.fizzbuzz = fizz * buzz;
    }

    private static final String FIZZ = "FIZZ";
    private static final String BUZZ = "BUZZ";
    private static final String FIZZBUZZ = FIZZ + BUZZ;

    @Override
    public String apply(int value) {
        return isMultiple(value, fizzbuzz) ? FIZZBUZZ : (isMultiple(value, fizz) ? FIZZ : (isMultiple(value, buzz) ? "BUZZ" : Integer.toString(value)));
    }

    private boolean isMultiple(int value, int factor) {
        return value % factor == 0;
    }

}
