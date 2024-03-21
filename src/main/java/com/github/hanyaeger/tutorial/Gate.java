package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Gate extends SpriteEntity implements Collider {
   public Gate(Coordinate2D initialLocation) {
       super("sprites/gate.png", initialLocation);
    }

    void removeGate() {

    }
}
