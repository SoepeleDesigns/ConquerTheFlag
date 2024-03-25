package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.*;
import com.github.hanyaeger.tutorial.Character;
import com.github.hanyaeger.tutorial.Switch;
import com.github.hanyaeger.tutorial.Flag;
import com.github.hanyaeger.tutorial.Pickaxe;
import com.github.hanyaeger.tutorial.map.BlockTileMap;
import com.github.hanyaeger.tutorial.map.BreakableBlock;

public class GameScene extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

    ConquerTheFlag conquerTheFlag;

    BlockTileMap blockTileMap = new BlockTileMap();

    public GameScene(ConquerTheFlag conquerTheFlag){
        this.conquerTheFlag = conquerTheFlag;
    }
    @Override
    public void setupScene(){
        //setBackgroundAudio("audio/level2.mp3");
        setBackgroundImage("backgrounds/level2.jpg");
    }

    @Override
    public void setupEntities() {

        Character character = new Character(
                new Coordinate2D(0, 0), conquerTheFlag);

        Door door = new Door(
                new Coordinate2D(getWidth() - 100, 0));

        Switch lever = new Switch(
              new Coordinate2D(200, getHeight() - 50), door);


        Flag flag = new Flag(
                new Coordinate2D(getWidth() - 400, getHeight() - 60));

        Pickaxe pickaxe = new Pickaxe(
                new Coordinate2D(300, 300));


        addEntity(door);
        addEntity((lever));
        addEntity(flag);
        addEntity(pickaxe);
        addEntity(character);

    }

    @Override
    public void setupEntitySpawners() {

    }

    public void setupTileMaps() {
        addTileMap(blockTileMap);
    }

}
