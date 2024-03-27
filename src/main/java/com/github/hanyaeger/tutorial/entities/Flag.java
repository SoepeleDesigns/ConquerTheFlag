package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Flag extends SpriteEntity implements Collider {
    public Flag(Coordinate2D initialLocation) {
        super("sprites/flag.png", initialLocation, new Size(50, 50));
    }
}
