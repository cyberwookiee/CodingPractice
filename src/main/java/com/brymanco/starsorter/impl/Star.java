package com.brymanco.starsorter.impl;

import com.brymanco.starsorter.IStar;

public class Star implements IStar {

    private final long x;

    private final long y;

    private final long z;

    private final String name;

    public Star(long x, long y, long z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    @Override
    public long getX() {
        return x;
    }

    @Override
    public long getY() {
        return y;
    }

    @Override
    public long getZ() {
        return z;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getDistanceFromEarth() {
        return Math.sqrt(this.getX() + this.getY() + this.getZ());
    }

}
