package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

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
