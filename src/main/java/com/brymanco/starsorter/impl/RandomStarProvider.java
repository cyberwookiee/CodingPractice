package com.brymanco.starsorter.impl;

import com.brymanco.starsorter.IStarProvider;
import java.util.Optional;
import java.util.Random;
import org.apache.commons.lang3.mutable.MutableLong;

public class RandomStarProvider implements IStarProvider {

    private final long totalStars;

    private final MutableLong starIndex;

    private final Random rand;
    
    private final IRandomNameProvider nameProvider;

    public RandomStarProvider(
            final long totalStars,
            final IRandomSeedProvider seedProvider,
            final IRandomNameProvider nameProvider
    ) {
        this.totalStars = totalStars;
        this.starIndex = new MutableLong(0);
        this.rand = new Random(seedProvider.getSeed());
        this.nameProvider = nameProvider;
    }

    @Override
    public Optional<Star> getNextStar() {
        if (starIndex.getValue() < totalStars) {
            return Optional.of(
                    new Star(
                            this.rand.nextLong(),
                            this.rand.nextLong(),
                            this.rand.nextLong(),
                            nameProvider.getName()));
        } else {
            return null;
        }

    }

}
