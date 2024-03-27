package com.github.hanyaeger.tutorial.entities.lever;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

import java.util.ArrayList;

public class Switch extends SpriteEntity implements Collider {

    ArrayList<Doelwit> doelwitten = new ArrayList<Doelwit>();


    public Switch(Coordinate2D initialLocation, Door door, Gate gate) {
        super("sprites/switch.png", initialLocation, new Size(50, 50), 1,2);
        setCurrentFrameIndex(1);
        doelwitten.add(door);
        doelwitten.add(gate);
    }

    public Switch(Coordinate2D initialLocation, Gate gate) {
        super("sprites/switch.png", initialLocation, new Size(50, 50), 1,2);
        setCurrentFrameIndex(1);
        doelwitten.add(gate);
    }

   public void switching() {
        setCurrentFrameIndex(0);
        System.out.println("Hij komt binnen switchen maar niet de doelwit");
        for (Doelwit doelwit : doelwitten)
        {
            doelwit.open();
            System.out.println("Hij komt er binnen");
        }
    }
}
