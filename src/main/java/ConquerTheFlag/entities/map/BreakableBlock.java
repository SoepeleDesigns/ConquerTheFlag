package ConquerTheFlag.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class BreakableBlock extends Block {
    public BreakableBlock(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource);
    }

    public void breakWall() {
        remove();
    }
}
