package com.github.hanyaeger.tutorial.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class BreakableBlock extends SpriteEntity implements Collider {
    public BreakableBlock(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }

    public void breakWall() {
        remove();
    }
}
