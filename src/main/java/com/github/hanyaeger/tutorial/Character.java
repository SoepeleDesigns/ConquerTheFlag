package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.map.BreakableBlock;
import com.github.hanyaeger.tutorial.map.LaunchPad;
import com.github.hanyaeger.tutorial.map.UnbreakableBlock;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Character extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {
    ConquerTheFlag conquerTheFlag;
    private boolean touchdown = true;
    private boolean pickaxePickedup = false;
    private final double FALLING = 0.1;
    private final double NOTFALLING = 0;
    private boolean isInteracting = false;

    private final Animation leftAnimation = new LoopingAnimation(1, 1, 1, 8);
    private final Animation rightAnimation = new LoopingAnimation(2, 1, 2, 8);
    private final Animation idleAnimation = new LoopingAnimation(0, 0, 0, 0);
    private final Animation jumpAnimation = new LoopingAnimation(3, 1, 3, 1);

    public Character(Coordinate2D location, ConquerTheFlag conquerTheFlag) {
        super("sprites/character.png", location, 4, 9);
        this.conquerTheFlag = conquerTheFlag;
        setGravityConstant(FALLING);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        // System.out.println("hij werkt met keycode printen" + pressedKeys);
        if (touchdown) {
            if (pressedKeys.contains(KeyCode.SPACE)) {
                setGravityConstant(FALLING);
                playAnimation(jumpAnimation);
                if (touchdown) {
                    setMotion(7, 180d);
                }
                if (pressedKeys.contains(KeyCode.LEFT)) {
                    setMotion(7, 200d);

                } else if (pressedKeys.contains(KeyCode.RIGHT)) {
                    setMotion(7, 150d);
                }
                isInteracting = false;
                touchdown = false;
            } else if (pressedKeys.contains(KeyCode.LEFT)) {
                setMotion(3, 270d);
                playAnimation(leftAnimation);
                isInteracting = false;
            } else if (pressedKeys.contains(KeyCode.RIGHT)) {
                setMotion(3, 90d);
                playAnimation(rightAnimation);
                isInteracting = false;
            } else if (pressedKeys.isEmpty()) {
                setSpeed(0);
                playAnimation(idleAnimation);
                isInteracting = false;
            } else if (pressedKeys.contains(KeyCode.E)) {
                isInteracting = true;
            }
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
                setGravityConstant(NOTFALLING);
                playAnimation(idleAnimation);
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
        LaunchPad launchPad;

        BreakableBlock collidedBreakableBlock;
        for (Collider collider : collidingObject) {
            if (collider instanceof Switch) {
               // System.out.println("SWITCH");
                if (isInteracting)
                {
                    collidedSwitch = (Switch)collider;
                    collidedSwitch.switching();
                    isInteracting = false;
                }
            }
            if (collider instanceof Flag)
            {
                System.out.println("FLAG");

                if (isInteracting) {
                    isInteracting = false;
                    conquerTheFlag.setActiveScene(2);
                }
            }
            if (collider instanceof Gate) {

            }
            if (collider instanceof Door)
            {
                collidedDoor = (Door)collider;
                if (collidedDoor.isOpened)
                {
                    if (isInteracting)
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
            if (collider instanceof BreakableBlock) {
                //System.out.println("Breakable Block");
                collidedBreakableBlock = (BreakableBlock)collider;

               if (pickaxePickedup && isInteracting)
               {
                   collidedBreakableBlock.breakWall();
                   isInteracting = false;
               }
            }
            if (collider instanceof UnbreakableBlock)
            {
                platform = (UnbreakableBlock)collider;
                //"case 150 -- detection above
                setAnchorLocationY(platform.getBoundingBox().getMinY() - getHeight());
                System.out.println((int)getDirection());
                setGravityConstant(FALLING);
                touchdown = true;
                System.out.println(getBoundingBox().getWidth());

                if (getAnchorLocation().getX() < getBoundingBox().getMinX() + 0)
                {
                        playAnimation(jumpAnimation);
                        setGravityConstant(FALLING);
                        touchdown = false;
                }
            }
            if (collider instanceof LaunchPad)
            {
                if ((int)getDirection() == 90)
                {
                    playAnimation(jumpAnimation);
                    setMotion(10, 150d);
                    setGravityConstant(FALLING);
                    touchdown = false;
                }
                if ((int)getDirection() == 270)
                {
                    playAnimation(jumpAnimation);
                    setMotion(10, 200d);
                    setGravityConstant(FALLING);
                    touchdown = false;
                }
            }
            }
        }
    }


