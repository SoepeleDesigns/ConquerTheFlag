package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.map.UnbreakableBlock;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Character extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {
    private final Animation idleLeftAnimation = new LoopingAnimation(1, 1, 1, 8);
    private final Animation idleRightAnimation = new LoopingAnimation(2, 1, 2, 8);
    private final Animation idleAnimation = new LoopingAnimation(0, 0, 0, 0);
    private final Animation jumpAnimation = new LoopingAnimation(3, 1, 3, 1);

    private boolean movementAllowed;

    private boolean touchdown = true;
    ConquerTheFlag conquerTheFlag;
    //switchCollision blijft true als eenmaal true!!!
    private boolean switchCollision = false;
    private final double FALLING = 0.1;
    private final double NOTFALLING = 0;

    private boolean isInteracting = false;
    public Character(Coordinate2D location, ConquerTheFlag conquerTheFlag) {
        super("sprites/character.png", location, 4, 9);
        this.conquerTheFlag = conquerTheFlag;
        setGravityConstant(FALLING);
    }


    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        // System.out.println("hij werkt met keycode printen" + pressedKeys);
        if (movementAllowed) {


            if (touchdown == false) {
                setGravityConstant(FALLING);
            }
            if (pressedKeys.contains(KeyCode.SPACE)) {
                setGravityConstant(FALLING);
                playAnimation(jumpAnimation);
                if (touchdown) {
                    setMotion(7, 180d);
                }

                //  System.out.println("hij werkt met printen");
                if (pressedKeys.contains(KeyCode.LEFT) && touchdown) {
                    setMotion(7, 200d);

                } else if (pressedKeys.contains(KeyCode.RIGHT) && touchdown) {
                    setMotion(7, 150d);
                }
                isInteracting = false;
                touchdown = false;
            } else if (pressedKeys.contains(KeyCode.LEFT) && touchdown) {
                setMotion(3, 270d);
                playAnimation(idleLeftAnimation);
                isInteracting = false;
            } else if (pressedKeys.contains(KeyCode.RIGHT) && touchdown) {
                setMotion(3, 90d);
                playAnimation(idleRightAnimation);
                isInteracting = false;
            } else if (pressedKeys.isEmpty() && touchdown) {
                setSpeed(0);
                playAnimation(idleAnimation);
                isInteracting = false;
            } else if (pressedKeys.contains(KeyCode.E)) {
                isInteracting = true;
            }
        }
        movementAllowed = false;
    }


    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                movementAllowed = true;
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                touchdown = true;
                setGravityConstant(NOTFALLING);
                playAnimation(idleAnimation);
                movementAllowed = true;
                break;
            case LEFT:
                setAnchorLocationX(1);
                movementAllowed = true;
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
                movementAllowed = true;
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
        Hitbox hitbox;
        boolean pickaxePickedup;
        for (Collider collider : collidingObject) {
            if (collider instanceof Switch) {
                switchCollision = true;
               // System.out.println("SWITCH");
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
                //"case 150 -- detection above
                setAnchorLocationY(platform.getBoundingBox().getMinY() - getHeight());

                System.out.println((int)getDirection());
                setGravityConstant(FALLING);
                touchdown = true;
                movementAllowed = true;
                /*
                switch ((int)getDirection())
                {
                    case 90: // van links
                        setAnchorLocationX(platform.getBoundingBox().getMinX() - getWidth() - 10);
                        touchdown = true;
                        System.out.println("detection LINKERZIJDE");
                        break;

                    case 180:
                        // van onder
                        setAnchorLocationY(platform.getBoundingBox().getMaxY() + 30);
                        System.out.println("detection onder");
                        touchdown = true;
                        break;

                    case 270:
                        setAnchorLocationX(platform.getBoundingBox().getMaxX() + 10);
                        touchdown = true;
                        System.out.println("detection zijde");
                        break;

                            //van boven
                }

                 */
            }
            if (collider instanceof Hitbox) {
                System.out.println("Hitbox");
                hitbox = (Hitbox)collider;
                //"case 150 -- detection above
                setAnchorLocationY(hitbox.getBoundingBox().getMinY() - getHeight());
                System.out.println("detection boven");
                setGravityConstant(FALLING);
                touchdown = true;

            }
            }
        }
    }


