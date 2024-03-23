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

public class TitleScene extends StaticScene {

    private ConquerTheFlag conquerTheFlag;

    public TitleScene(ConquerTheFlag conquerTheFlag){
        this.conquerTheFlag = conquerTheFlag;
    }

    @Override
    public void setupScene(){
        //setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities(){
        var conquerTheFlagText = new TextEntity(
                new Coordinate2D(0 , getHeight() / 4),
                "ConquerTheFLag"
        );
        conquerTheFlagText.setFill(Color.PURPLE);
        conquerTheFlagText.setFont(Font.font("Roboto", FontWeight.BOLD, 100));
        addEntity(conquerTheFlagText);

        Button button = new Button(
                new Coordinate2D(getWidth() / 3,getHeight() / 2), conquerTheFlag);
        addEntity(button);
    }
}
