package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class BreakableBlock extends SpriteEntity implements Collider {
    public BreakableBlock(Coordinate2D initialLocation) {
        super("sprites/breakableblock.png", initialLocation, new Size(50, 50));
    }

    public void breakWall() {

    }
}
