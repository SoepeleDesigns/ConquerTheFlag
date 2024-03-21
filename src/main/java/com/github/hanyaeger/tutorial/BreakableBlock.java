package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;

public class BreakableBlock extends Block implements Collider {
    public BreakableBlock(Coordinate2D initialLocation) {
        super("sprites/breakableblock.png", initialLocation);
    }

    public void breakWall() {

    }
}
