package ConquerTheFlag.scenes;

import ConquerTheFlag.ConquerTheFlag;
import ConquerTheFlag.entities.Character;
import ConquerTheFlag.entities.Flag;
import ConquerTheFlag.entities.Pickaxe;
import ConquerTheFlag.entities.lever.Gate;
import ConquerTheFlag.entities.lever.Switch;
import ConquerTheFlag.entities.map.BlockTileMap;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.*;

public class GameScene extends DynamicScene implements TileMapContainer {
    ConquerTheFlag conquerTheFlag;
    BlockTileMap blockTileMap = new BlockTileMap();

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
                new Coordinate2D(0, getHeight()), conquerTheFlag);

        Gate gate = new Gate(new Coordinate2D(200, 183));

        Switch lever = new Switch(
                new Coordinate2D(200, getHeight() - 40), gate);
        Flag flag = new Flag(
                new Coordinate2D(getWidth() - 60, getHeight() - 60));

        Pickaxe pickaxe = new Pickaxe(
                new Coordinate2D(410, 415));

        addEntity(lever);
        addEntity(gate);
        addEntity(flag);
        addEntity(pickaxe);
        addEntity(character);

    }

    public void setupTileMaps() {
        addTileMap(blockTileMap);
    }

}
