package com.brymanco.starsorter;

import com.brymanco.starsorter.impl.Star;
import java.util.Optional;

public interface IStarProvider {

    public Optional<Star> getNextStar();

}
