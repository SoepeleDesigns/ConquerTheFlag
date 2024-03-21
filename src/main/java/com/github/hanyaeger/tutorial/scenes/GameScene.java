package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.ConquerTheFlag;


public class GameScene extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

    ConquerTheFlag conquerTheFlag;

    public GameScene(ConquerTheFlag conquerTheFlag){
        this.conquerTheFlag = conquerTheFlag;
    }
    @Override
    public void setupScene(){
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupEntitySpawners() {

    }

    @Override
    public void setupTileMaps() {
        addTileMap(coralTileMap);
    }
}
