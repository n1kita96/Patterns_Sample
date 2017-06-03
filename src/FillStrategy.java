import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 * Created by N1kita on 25.05.2017.
 */
public class FillStrategy implements Strategy {

    public void paint(Wall wall) {
        wall.wallIV.setImage(new Image("colorful_block.png"));
        wall.wallIV.setViewport(new Rectangle2D(16,4 * 16, 16, 16));
    }
}
