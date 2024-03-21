package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.ConquerTheFlag;

public class EndScene extends StaticScene {

    private ConquerTheFlag conquerTheFlag;

    public EndScene(ConquerTheFlag conquerTheFlag){
        this.conquerTheFlag = conquerTheFlag;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background3.jpg");
    }

    @Override
    public void setupEntities() {

    }
}
