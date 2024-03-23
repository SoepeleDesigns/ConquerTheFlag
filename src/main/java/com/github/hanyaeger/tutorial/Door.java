package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Door extends SpriteEntity implements Collider {
    boolean isOpened;

    public Door(Coordinate2D initialLocation) {
        super("sprites/door.png", initialLocation, 1, 1);

    }

    void openDoor() {

    }
}
