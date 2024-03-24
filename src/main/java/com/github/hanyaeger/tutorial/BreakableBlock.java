package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

public class BreakableBlock extends Block implements Collider {
    public BreakableBlock(Coordinate2D initialLocation) {
        super("sprites/breakableblock.png", initialLocation, new Size(50, 50));
    }

    public void breakWall() {

    }
}
