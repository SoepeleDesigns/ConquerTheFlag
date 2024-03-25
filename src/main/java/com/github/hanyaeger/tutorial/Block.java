package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import javafx.scene.paint.Color;

public abstract class Block extends CompositeEntity implements Collider {

    public Block(Coordinate2D initialLocation) {
       super(initialLocation);

       setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    protected void setupEntities() {

    }


}
