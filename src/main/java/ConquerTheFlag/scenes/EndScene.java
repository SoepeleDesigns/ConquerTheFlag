package ConquerTheFlag.scenes;

import ConquerTheFlag.ConquerTheFlag;
import ConquerTheFlag.entities.Button;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndScene extends StaticScene {

    private ConquerTheFlag conquerTheFlag;

    public EndScene(ConquerTheFlag conquerTheFlag){
        this.conquerTheFlag = conquerTheFlag;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/GameOver.mp3");
        setBackgroundImage("backgrounds/gameovermenu.png");
    }

    @Override
    public void setupEntities() {

        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 4 + 10, getHeight() / 3),
                "U heeft gewonnen!"
        );
        gameOverText.setFill(Color.WHITE);
        gameOverText.setFont(Font.font("Roboto", FontWeight.BOLD, 40));

        addEntity(gameOverText);

        Button button = new Button(
                new Coordinate2D(getWidth() / 3,getHeight() / 2), conquerTheFlag, "Nieuw Spel", 1);

        addEntity(button);
    }
}
