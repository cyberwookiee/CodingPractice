package com.brymanco.test;

import com.brymanco.fizzbuzz.impl.FizzBuzzValueMapper;
import com.brymanco.fizzbuzz.IRangeProcessor;
import com.brymanco.fizzbuzz.impl.StreamRangeProcessor;
import org.junit.jupiter.api.Test;

public class RangeProcessorTests {

    @Test
    public void verifyFizzBuzz() {
        IRangeProcessor processor = new StreamRangeProcessor();

        processor.processRange(1, 100, new FizzBuzzValueMapper(5, 7), System.out::println);

    }

}
