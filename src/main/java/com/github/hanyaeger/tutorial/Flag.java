package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Flag extends SpriteEntity implements Collider {
    public Flag(String resource, Coordinate2D initialLocation) {
        super("sprites/'flag'.png", initialLocation);
    }
}
