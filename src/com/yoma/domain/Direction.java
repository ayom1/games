package com.yoma.domain;

public enum Direction {
    UP(1),
    DOWN(2),
    LEFT(3),
    RIGHT(4);

    private int direction;
    Direction(final int dir){
        this.direction = dir;
    }
}
