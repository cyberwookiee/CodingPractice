package com.brymanco.parking;

import java.util.Comparator;

public class SpaceInfo {

    private final CarSize size;

    private final int space;

    private final char section;

    private final int level;

    public SpaceInfo(
            final CarSize size,
            final int space,
            final char section,
            final int level) {
        this.size = size;
        this.space = space;
        this.section = section;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public char getSection() {
        return section;
    }

    public int getSpaceNumber() {
        return space;
    }

    public CarSize getSize() {
        return size;
    }

    /**
     * Assumes that spaces on lower levels are closer than spaces on higher
     * levels. Assumes that spaces in lower sections are closer than spaces in
     * higher sections. Assumes that spaces with lower numbers are closer than
     * spaces with higher numbers.
     */
    public static Comparator<SpaceInfo> SPACE_COMPARER = (space1, space2) -> {
        if (space1.getLevel() == space2.getLevel()) {
            if (space1.getSection() == space2.getSection()) {
                if (space1.getSpaceNumber() == space2.getSpaceNumber()) {
                    return 0;
                } else {
                    return Integer.compare(space1.getSpaceNumber(), space2.getSpaceNumber());
                }
            } else {
                return Character.compare(space1.getSection(), space2.getSection());
            }
        } else {
            return Integer.compare(space1.getLevel(), space2.getLevel());
        }
    };

}
