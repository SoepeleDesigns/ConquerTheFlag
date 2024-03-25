package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class UnbreakableBlock extends SpriteEntity {
    public UnbreakableBlock(Coordinate2D initialLocation) {
        super("sprites/unbreakableblock.png", initialLocation, new Size(70, 70));
    }
}
