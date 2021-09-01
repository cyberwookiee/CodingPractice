package com.brymanco.starsorter.impl;

import java.time.Instant;

public class RandomSeedProvider implements IRandomSeedProvider {

    @Override
    public long getSeed() {
        return Instant.now().toEpochMilli();
    }

}
