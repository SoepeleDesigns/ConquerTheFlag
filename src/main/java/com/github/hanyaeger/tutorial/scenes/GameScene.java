package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.*;
import com.github.hanyaeger.tutorial.Character;
import com.github.hanyaeger.api.Size;


public class GameScene extends DynamicScene implements EntitySpawnerContainer {

    ConquerTheFlag conquerTheFlag;

    public GameScene(ConquerTheFlag conquerTheFlag){
        this.conquerTheFlag = conquerTheFlag;
    }
    @Override
    public void setupScene(){
        //setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/level2.jpg");
    }

    @Override
    public void setupEntities() {

        Character character = new Character(
                new Coordinate2D(0, 0));

        Door door = new Door(
                new Coordinate2D(0, 0));

        addEntity(door);


      BreakableBlock breakableBlock = new BreakableBlock(
               new Coordinate2D(0, 50));
                addEntity((breakableBlock));
       addEntity(character);

   UnbreakableBlock unbreakableBlock = new UnbreakableBlock(
                new Coordinate2D(500, 50));
       addEntity(unbreakableBlock);
    }

    @Override
    public void setupEntitySpawners() {

    }
}
