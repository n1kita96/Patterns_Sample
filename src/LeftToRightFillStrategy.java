import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

/**
 * Created by N1kita on 25.05.2017.
 */
public class LeftToRightFillStrategy implements Strategy {

    public void paint(Wall wall) {

        InnerShadow is = new InnerShadow();
        is.setColor(Color.DARKBLUE);
        is.setOffsetX(15);
        is.setWidth(50);
        is.setHeight(0);
        wall.setEffect(is);
        wall.wallIV.setEffect(is);
    }
}
