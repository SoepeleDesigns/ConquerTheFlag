package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Button;
import com.github.hanyaeger.tutorial.ConquerTheFlag;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Scanner;

public class TitleScene extends StaticScene {

    private ConquerTheFlag conquerTheFlag;

    public TitleScene(ConquerTheFlag conquerTheFlag){
        this.conquerTheFlag = conquerTheFlag;
    }

    @Override
    public void setupScene(){
        setBackgroundAudio("audio/ConquerTheFlag.mp3");
        setBackgroundImage("backgrounds/menubackground.png");
    }

    @Override
    public void setupEntities(){

        var conquerTheFlagText = new TextEntity(
                new Coordinate2D(getWidth() / 3 - 20 , getHeight() / 4 - 30),
                "Conquer the Flag!"
        );
        conquerTheFlagText.setFill(Color.BLUEVIOLET);
        conquerTheFlagText.setFont(Font.font("Roboto", FontWeight.BOLD, 50));
        addEntity(conquerTheFlagText);

        Button button = new Button(
                new Coordinate2D(getWidth() / 3,getHeight() / 2), conquerTheFlag, "Start game");
        addEntity(button);
    }
}
