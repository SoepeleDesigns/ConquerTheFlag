package com.github.hanyaeger.tutorial.entities.lever;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Gate extends Doelwit {
    public Gate(Coordinate2D initialLocation) {
        super(initialLocation, new Size(50,97), "sprites/gate.png");
    }

    @Override
    public void open() {
        System.out.println("Gate geopend!");
        isOpened = true;
        setCurrentFrameIndex(1);
    }

}
