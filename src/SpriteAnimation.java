import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Created by N1kita on 07.03.2017.
 */
public class SpriteAnimation extends Transition {
    private final ImageView imageView;
    private final int rows;
    private final int columns;
    private  int offsetX;
    private  int offsetY;
    private final int width;
    private final int height;

    public SpriteAnimation(
            ImageView imageView,
            Duration duration,
            int rows, int columns,
            int offsetX, int offsetY,
            int width, int height){
        this.imageView = imageView;
        this.rows = rows;
        this.columns = columns;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        setCycleDuration(duration);
        setCycleCount(Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
    }
    public void setOffsetX(int x){
        this.offsetX = x;
    }
    public void setOffsetY(int y){
        this.offsetY = y;
    }

    protected void interpolate(double k){
        final int index = Math.min((int)Math.floor(k*rows),rows-1);
        final int x = (index % columns) * width + offsetX;
        final int y = (index / columns) * height + offsetY;
        imageView.setViewport(new Rectangle2D(x, y, width, height));
    }
}
