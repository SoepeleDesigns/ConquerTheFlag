package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Character extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {
    private final Animation idleLeftAnimation = new LoopingAnimation(1, 1, 1, 8);
    private final Animation idleRightAnimation = new LoopingAnimation(2, 1, 2, 8);
    private final Animation idleAnimation = new LoopingAnimation(0, 0, 0, 0);

    boolean isMoving = true;
    public Character(Coordinate2D location) {
        super("sprites/character.png", location, 4, 9);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT) && isMoving == true){
            setMotion(3,270d);
           playAnimation(idleLeftAnimation);
        } else if(pressedKeys.contains(KeyCode.RIGHT) && isMoving == true){
            setMotion(3,90d);
            playAnimation(idleRightAnimation);
        } else if(pressedKeys.contains(KeyCode.SPACE)){
            isMoving = false;
            setMotion(3,180d);
            setCurrentFrameIndex(1);
        } else if(pressedKeys.isEmpty()){
             setSpeed(0);
             playAnimation(idleAnimation);
             isMoving = true;
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(List<Collider> list) {

    }
}
