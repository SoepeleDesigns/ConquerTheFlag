package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Switch extends SpriteEntity implements Collider {
    Gate gate;
    Door door;

    public Switch(Coordinate2D initialLocation, Door door, Gate gate) {
        super("sprites/switch.png", initialLocation, new Size(50, 50), 1,2);
        this.door = door;
        this.gate = gate;
        setCurrentFrameIndex(1);

    }

    public Switch(Coordinate2D initialLocation, Gate gate) {
        super("sprites/switch.png", initialLocation, new Size(50, 50), 1,2);
        this.gate = gate;
        setCurrentFrameIndex(1);

    }

    void switching() {
        setCurrentFrameIndex(0);

        if (this.door == null)
        {
                // do nothing
        }
        else
        {
            door.openDoor();
        }
        if (this.gate == null)
        {
            // do nothing
        }
        else
        {
            gate.openGate();
        }
    }
}
