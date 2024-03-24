package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Door extends SpriteEntity implements Collider {
    boolean isOpened = false;

    public Door(Coordinate2D initialLocation) {
        super("sprites/door.png", initialLocation, 1, 2);
        setCurrentFrameIndex(0);
    }

    void openDoor() {
        isOpened = true;
        setCurrentFrameIndex(1);
    }
}
