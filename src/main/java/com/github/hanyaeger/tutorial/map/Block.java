package com.github.hanyaeger.tutorial.map;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Block extends SpriteEntity implements Collider {
    public Block(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}
