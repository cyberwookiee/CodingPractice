package com.brymanco.test;

import com.brymanco.duplicatefinder.impl.SumDuplicateFinder;
import com.brymanco.duplicatefinder.IDuplicateFinder;
import com.brymanco.duplicatefinder.impl.HashSortDuplicateFinder;
import com.brymanco.duplicatefinder.impl.HashSetDuplicateFinder;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class DuplicateFinderTests {

    @Test
    public void verifyHashSort() throws InterruptedException {
        IDuplicateFinder finder = new HashSortDuplicateFinder();
        verifyFinder(finder);
    }

    @Test
    public void verifySum() throws InterruptedException {
        IDuplicateFinder finder = new SumDuplicateFinder();
        verifyFinder(finder);
    }

    @Test
    public void verifyHashSet() throws InterruptedException {
        IDuplicateFinder finder = new HashSetDuplicateFinder();
        verifyFinder(finder);
    }

    private void verifyFinder(IDuplicateFinder finder) {
        final Random rand = new Random();

        rand.setSeed(Instant.now().toEpochMilli());

        final int size = 1000;

        long totalNanos = 0;

        for (int zz = 0; zz < 10_000; zz++) {

            List<Integer> list = new ArrayList<>();

            for (int ii = 1; ii < size; ii++) {
                list.add(ii);
            }

            int solution = rand.nextInt(size - 1) + 1;

            list.add(solution);

            for (int ii = 0; ii < 10; ii++) {
                Collections.shuffle(list, rand);
            }

            Integer[] arr = list.toArray(new Integer[0]);
            Instant start = Instant.now();
            long dup = finder.findDuplicate(arr);
            Instant stop = Instant.now();

            totalNanos += Duration.between(start, stop).toNanos();

            if (dup != solution) {
                System.out.println(Arrays.toString(arr) + " -> " + dup);
                break;
            }

        }

        System.out.println(finder.getClass().getSimpleName() + ": " + Duration.ofNanos(totalNanos));

    }
}
