package com.brymanco.starsorter.impl;

import com.brymanco.starsorter.IStarProvider;
import com.brymanco.starsorter.IStarSorter;
import java.util.Collection;
import java.util.Optional;
import java.util.PriorityQueue;

public class StarSorter implements IStarSorter {

    private final IStarProvider provider;

    public StarSorter(IStarProvider provider) {
        this.provider = provider;
    }

    @Override
    public Collection<Star> findClosestToEarth(int numClosest) {

        final PriorityQueue<Star> stars = new PriorityQueue<>(
                numClosest,
                (a, b) -> {
                    final Double aDist = a.getDistanceFromEarth();
                    final Double bDist = b.getDistanceFromEarth();
                    return aDist.compareTo(bDist) * -1;
                });

        Optional<Star> star = provider.getNextStar();

        while (star.isPresent()) {
            final Double dist = star.get().getDistanceFromEarth();

            final Double headDist = stars.peek() == null ? null : stars.peek().getDistanceFromEarth();

            if (headDist == null || dist < headDist) {
                stars.add(star.get());
            }

            if (stars.size() > 100) {
                stars.poll();
            }

            star = provider.getNextStar();

        }

        return stars;
    }

}
