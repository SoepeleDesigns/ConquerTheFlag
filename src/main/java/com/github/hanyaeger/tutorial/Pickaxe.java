package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Pickaxe extends SpriteEntity implements Collider {
    boolean pickedUp;
    BreakableBlock wall;

    Pickaxe(Coordinate2D initialLocation) {

    }

    void mining () {

    }
}
