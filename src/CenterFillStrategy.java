import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

/**
 * Created by N1kita on 25.05.2017.
 */
public class CenterFillStrategy implements Strategy {

    public void paint(Wall wall) {
        InnerShadow is = new InnerShadow();
        is.setColor(Color.CYAN);
        is.setWidth(60);
        is.setHeight(60);
        wall.setEffect(is);
        wall.wallIV.setEffect(is);
    }
}
