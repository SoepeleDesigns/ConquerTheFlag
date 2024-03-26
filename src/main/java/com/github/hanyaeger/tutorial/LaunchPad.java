package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class LaunchPad extends SpriteEntity implements Collider {
    public LaunchPad(Coordinate2D initialLocation) {
        super("sprites/launchpad.png", initialLocation);
    }
}
