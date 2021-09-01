package com.brymanco.bogglesolver.impl;

import com.brymanco.bogglesolver.Board;
import com.brymanco.bogglesolver.BoardGenerator;
import java.time.Instant;
import java.util.Random;

public class BoardGeneratorImpl implements BoardGenerator {

    private final int START = 97;
    private final Random rand;

    public BoardGeneratorImpl() {
        rand = new Random();
        rand.setSeed(Instant.now().getNano());
    }

    @Override
    public Board generate(final int rowLength) {
        final int numCharsToGenerate = rowLength * rowLength;

        final StringBuilder sb = new StringBuilder();

        for (int ii = 0; ii < numCharsToGenerate; ii++) {
            sb.append(createRandomChar(rand));
        }

        return new BoardImpl(sb.toString(), rowLength);

    }

    private char createRandomChar(final Random rand) {
        return (char) (rand.nextInt(26) + START);
    }

}
