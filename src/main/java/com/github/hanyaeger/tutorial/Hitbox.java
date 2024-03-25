package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class Hitbox extends RectangleEntity implements Collider {
    public static final double OPACITY = 0;
    private static final Color COLOR = Color.RED;

    public Hitbox(final Coordinate2D initialLocation, final Size size) {
        super(initialLocation, size);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        setFill(COLOR);
        //setOpacity(OPACITY);
    }
}
