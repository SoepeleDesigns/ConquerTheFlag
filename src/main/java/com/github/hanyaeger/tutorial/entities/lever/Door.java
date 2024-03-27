package com.github.hanyaeger.tutorial.entities.lever;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Door extends Doelwit {

    public Door(Coordinate2D initialLocation) {
        super(initialLocation, new Size(50,50), "sprites/door.png");
    }

    @Override
    public void open() {
        isOpened = true;
        setCurrentFrameIndex(1);
    }
}
