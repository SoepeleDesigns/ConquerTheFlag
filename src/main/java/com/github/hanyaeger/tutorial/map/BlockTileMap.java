package com.github.hanyaeger.tutorial.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.TileMap;

public class BlockTileMap extends TileMap {


    @Override
    public void setupEntities() {
        addEntity(1, UnbreakableBlock.class, "sprites/unbreakableblock.png");
        addEntity(2, BreakableBlock.class, "sprites/breakableblock.png");
        addEntity(3, LaunchPad.class, "sprites/launchpad.png");
    }

    @Override
    public int[][] defineMap() {
        return new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 2, 2, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 2, 2, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0},
        };
    }
}
