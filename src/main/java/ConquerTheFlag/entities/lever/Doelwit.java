package ConquerTheFlag.entities.lever;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Doelwit extends SpriteEntity implements Collider {
    public boolean isOpened = false;
    public Doelwit (Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size, 1, 2);
    }

    public abstract void open();
}
