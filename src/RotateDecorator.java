import javafx.animation.RotateTransition;
import javafx.util.Duration;

/**
 * Created by N1kita on 22.05.2017.
 */
public class RotateDecorator extends Decorator{

    public RotateDecorator(WallFactory component){
        super(component);
    }

    public Wall createWall(int x, int y) {
        Wall wall;
        wall = component.createWall(x,y);

        RotateTransition animation = new RotateTransition(Duration.seconds(1),wall);
        animation.setFromAngle(0);
        animation.setToAngle(360);
        wall.setOnMouseEntered(event -> {
            animation.play();
            });
        return wall;
    }

}
