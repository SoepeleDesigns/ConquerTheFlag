package ConquerTheFlag;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import ConquerTheFlag.scenes.GameScene;
import ConquerTheFlag.scenes.EndScene;
import ConquerTheFlag.scenes.TitleScene;

// hello world
public class ConquerTheFlag extends YaegerGame {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Conquer the flag!");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes(){
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene(this));
        addScene(2, new EndScene(this));
    }

}
