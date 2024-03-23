package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Block extends SpriteEntity implements Collider {
    Block(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }


}
