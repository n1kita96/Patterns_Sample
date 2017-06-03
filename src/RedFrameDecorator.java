import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

/**
 * Created by N1kita on 22.05.2017.
 */
public class RedFrameDecorator extends Decorator {

    public InnerShadow is;

    public RedFrameDecorator(WallFactory component){
        super(component);
    }

    public Wall createWall(int x, int y) {
        Wall wall;
        wall = component.createWall(x,y);

        is = new InnerShadow();
        is.setColor(Color.RED);
        is.setWidth(5);
        is.setHeight(5);
        wall.setEffect(is);
        wall.wallIV.setEffect(is);
        return wall;
    }
}
