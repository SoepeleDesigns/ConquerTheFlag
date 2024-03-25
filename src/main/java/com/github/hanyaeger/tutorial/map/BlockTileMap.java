package com.github.hanyaeger.tutorial.map;

import com.github.hanyaeger.api.scenes.TileMap;

public class BlockTileMap extends TileMap {
    @Override
    public void setupEntities() {
        addEntity(1, UnbreakableBlock.class, "sprites/unbreakableblock.png");
        addEntity(2, BreakableBlock.class, "sprites/breakableblock.png");
    }

    @Override
    public int[][] defineMap() {
        return new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
        };
    }
}
