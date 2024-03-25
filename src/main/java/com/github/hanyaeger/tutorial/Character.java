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

    private boolean touchdown = true;
    ConquerTheFlag conquerTheFlag;
    //switchCollision blijft true als eenmaal true!!!
    private boolean switchCollision = false;
    private boolean isMoving = true;
    private boolean isInteracting = false;
    public Character(Coordinate2D location, ConquerTheFlag conquerTheFlag) {
        super("sprites/character.png", location, 4, 9);
        this.conquerTheFlag = conquerTheFlag;
    }


    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        System.out.println("hij werkt met keycode printen" + pressedKeys);
        if (pressedKeys.contains(KeyCode.SPACE))
        {
            touchdown = false;
            System.out.println("hij werkt met printen");
            if(pressedKeys.contains(KeyCode.LEFT) && isMoving)
            {
                setMotion(7,200d);
                setCurrentFrameIndex(1);
            }
            else if (pressedKeys.contains(KeyCode.RIGHT) && isMoving){
            setMotion(7,150d);
            setCurrentFrameIndex(1);
            }
            isInteracting = false;
            isMoving = false;
        }
        else if (pressedKeys.contains(KeyCode.LEFT) && isMoving){
            setMotion(3,270d);
           playAnimation(idleLeftAnimation);
            isInteracting = false;
        }
        else if(pressedKeys.contains(KeyCode.RIGHT) && isMoving){
            setMotion(3,90d);
            playAnimation(idleRightAnimation);
            isInteracting = false;
        }else if(pressedKeys.isEmpty() && touchdown){
             setSpeed(0);
             playAnimation(idleAnimation);
             isMoving = true;
             isInteracting = false;
        } else if(pressedKeys.contains(KeyCode.E)) {
            isInteracting = true;
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
                touchdown = true;
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
    public void onCollision(List<Collider> collidingObject) {
        Switch collidedSwitch;
        Door collidedDoor;
        UnbreakableBlock platform;
        Pickaxe collidedPickaxe;
        boolean pickaxePickedup;
        for (Collider collider : collidingObject) {
            if (collider instanceof Switch) {
                switchCollision = true;
                System.out.println("SWITCH");
                if (switchCollision == true && isInteracting == true)
                {
                    collidedSwitch = (Switch)collider;
                    collidedSwitch.switching();
                    isInteracting = false;
                }
            }
            if (collider instanceof Flag)
                System.out.println("FLAG");
            {
                if (isInteracting == true)
                {
                    isInteracting = false;
                    // commit
                    conquerTheFlag.setActiveScene(2);
                }
            }
            if (collider instanceof Door)
            {
                collidedDoor = (Door)collider;
                if (collidedDoor.isOpened == true)
                {
                    if (isInteracting == true)
                    {
                        isInteracting = false;
                        conquerTheFlag.setActiveScene(2);
                    }
                }
            }
            if (collider instanceof Pickaxe) {
                System.out.println("Pickaxe");
                pickaxePickedup = true;
                collidedPickaxe = (Pickaxe)collider;
                collidedPickaxe.pickaxeTopleft();
            }
            if (collider instanceof UnbreakableBlock)
            {
                platform = (UnbreakableBlock)collider;

                setSpeed(0);
                switch ((int)getDirection())
                {
                    case 90: // van links
                        setAnchorLocationX(platform.getBoundingBox().getMinX() - getWidth() - 10);
                        touchdown = true;
                        isMoving = true;
                        break;

                    case 180:
                        setAnchorLocationY(platform.getBoundingBox().getMaxY() + 10);
                        System.out.println("UP");
                        touchdown = true;
                        isMoving = true;
                        break;

                    case 270:
                        setAnchorLocationX(platform.getBoundingBox().getMaxX() + 10);
                        touchdown = true;
                        isMoving = true;
                        break;

                    case 0:
                        setAnchorLocationY(platform.getBoundingBox().getMinY() - getHeight());
                        System.out.println("DOWN");
                        touchdown = true;
                        isMoving = true;
                        break;
                }
            }
            }
        }
    }


