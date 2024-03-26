package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Gate extends Doelwit implements Collider {
    public Gate(Coordinate2D initialLocation) {
        super(initialLocation, new Size(20, 95), "sprites/gate.png");
    }

    public void openGate() {
        remove();
    }
}
