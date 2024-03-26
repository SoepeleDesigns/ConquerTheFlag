package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.*;
import com.github.hanyaeger.tutorial.Character;
import com.github.hanyaeger.tutorial.Switch;
import com.github.hanyaeger.tutorial.Flag;
import com.github.hanyaeger.tutorial.Pickaxe;
import com.github.hanyaeger.tutorial.map.BlockTileMap;

public class GameScene extends DynamicScene implements TileMapContainer {

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
                new Coordinate2D(getWidth(), 0), conquerTheFlag);

        Door door = new Door(
                new Coordinate2D(getWidth() - 100, 0));

        Switch lever = new Switch(
              new Coordinate2D(200, getHeight() -40), door);


        Flag flag = new Flag(
                new Coordinate2D(getWidth() - 60, getHeight() - 60));

        Pickaxe pickaxe = new Pickaxe(
                new Coordinate2D(410, 415));

        addEntity(door);
        addEntity((lever));
        addEntity(flag);
        addEntity(pickaxe);
        addEntity(character);

    }

    public void setupTileMaps() {
        addTileMap(blockTileMap);
    }

}
