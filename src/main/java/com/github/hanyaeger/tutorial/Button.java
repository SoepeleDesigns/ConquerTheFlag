package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Button extends TextEntity implements MouseExitListener, MouseEnterListener, MouseButtonPressedListener {
    private ConquerTheFlag conquerTheFlag;
    private int scene;

    public Button(Coordinate2D initialLocation, ConquerTheFlag conquerTheFlag, String text, final int scene) {
        super( initialLocation, text);
        this.conquerTheFlag = conquerTheFlag;
        this.scene = scene;
        setFill(Color.BLUEVIOLET);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseEntered(){
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.BLUEVIOLET);
        setCursor(Cursor.DEFAULT);
    }
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        conquerTheFlag.setActiveScene(getScene());
    }
    public int getScene() {
        return scene;
    }
}
