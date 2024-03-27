package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

import java.util.ArrayList;
import java.util.Deque;

public class Switch extends SpriteEntity implements Collider {

    ArrayList<Doelwit> doelwitten = new ArrayList<Doelwit>();

    public Switch(Coordinate2D initialLocation) {
        super("sprites/switch.png", initialLocation, new Size(50, 50), 1,2);
        setCurrentFrameIndex(1);
    }


   public void switching() {
        setCurrentFrameIndex(0);
        for (Doelwit doelwit : doelwitten)
        {
            doelwit.open();
        }
    }
}
