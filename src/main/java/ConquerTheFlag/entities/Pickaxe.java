package ConquerTheFlag.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Pickaxe extends SpriteEntity implements Collider {

    public Pickaxe(Coordinate2D initialLocation) {

        super("sprites/pickaxe.png", initialLocation, new Size(50, 50));
    }

    void pickaxeTopleft () {
        remove();
    }
}
