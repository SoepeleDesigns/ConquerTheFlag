package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;

public class UnbreakableBlock extends Block implements Collider {
    public UnbreakableBlock(Coordinate2D initialLocation) {
        super("sprites/unbreakableblock.png", initialLocation);
    }
}
