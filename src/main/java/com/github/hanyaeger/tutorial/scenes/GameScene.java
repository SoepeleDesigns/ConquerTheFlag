package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.*;
import com.github.hanyaeger.tutorial.Character;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.Switch;
import com.github.hanyaeger.tutorial.Flag;
import com.github.hanyaeger.tutorial.Pickaxe;

import java.util.Scanner;


public class GameScene extends DynamicScene implements EntitySpawnerContainer {


    ConquerTheFlag conquerTheFlag;

    public GameScene(ConquerTheFlag conquerTheFlag){
        this.conquerTheFlag = conquerTheFlag;
    }
    @Override
    public void setupScene(){
        setBackgroundAudio("audio/level2.mp3");
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

      BreakableBlock breakableBlock = new BreakableBlock(
               new Coordinate2D(0, 50));

   UnbreakableBlock unbreakableBlock = new UnbreakableBlock(
                new Coordinate2D(500, 50));

        Flag flag = new Flag(
                new Coordinate2D(getWidth() - 100, getHeight() - 60));

        Pickaxe pickaxe = new Pickaxe(
                new Coordinate2D(300, 300));

        addEntity(character);
        addEntity(door);
        addEntity((lever));
        addEntity(breakableBlock);
        addEntity(unbreakableBlock);
        addEntity(flag);
        addEntity(pickaxe);

        if x == true ->
    }

    @Override
    public void setupEntitySpawners() {

    }

}
