package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Switch extends SpriteEntity implements Collider {
    Gate gate;
    Door door;

    public Switch(Coordinate2D initialLocation) {
        super("sprites/switch.png", initialLocation, new Size(50, 50));
    }

    void switching() {

    }
}
