package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import javafx.scene.paint.Color;

public abstract class Block extends SpriteEntity implements Collider {

    public Block(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);

    }


}
