package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.BreakableBlock;
import com.github.hanyaeger.tutorial.ConquerTheFlag;
import com.github.hanyaeger.tutorial.Door;


public class GameScene extends DynamicScene implements EntitySpawnerContainer {

    ConquerTheFlag conquerTheFlag;

    public GameScene(ConquerTheFlag conquerTheFlag){
        this.conquerTheFlag = conquerTheFlag;
    }
    @Override
    public void setupScene(){
        //setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {


        Door door = new Door(
                new Coordinate2D(0, 0));

        addEntity(door);

        BreakableBlock breakableBlock = new BreakableBlock(
                new Coordinate2D(500, 0));
        addEntity((breakableBlock));
    }

    @Override
    public void setupEntitySpawners() {

    }
}
