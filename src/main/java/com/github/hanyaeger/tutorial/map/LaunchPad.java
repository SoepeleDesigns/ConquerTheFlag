package com.github.hanyaeger.tutorial.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class LaunchPad extends SpriteEntity implements Collider {

    public LaunchPad(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, new Size(40,10));
        setAnchorLocationY(getAnchorLocation().getY() + 45);
    }
}
