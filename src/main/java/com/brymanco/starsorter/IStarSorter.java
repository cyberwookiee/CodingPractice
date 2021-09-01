package com.brymanco.starsorter;

import com.brymanco.starsorter.impl.Star;
import java.util.Collection;

public interface IStarSorter {

    /**
     * Returns the numClosest stars to earth, where earth has a position of
     * 0,0,0
     *
     * @param numClosest
     * @return
     */
    Collection<Star> findClosestToEarth(int numClosest);

}
