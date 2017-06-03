import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by N1kita on 16.03.2017.
 */
public class Door extends Pane{
    Image image = new Image("door.png");
    ImageView imageView;

    public Door(int x, int y){
        imageView = new ImageView(image);

        imageView.setFitHeight(WindowView.BLOCK_SIZE);
        imageView.setFitWidth(WindowView.BLOCK_SIZE);

        setTranslateX(x);
        setTranslateY(y);

        imageView.setViewport(new Rectangle2D(0,0, 512,512));

        getChildren().add(imageView);
        WindowView.gameRoot.getChildren().add(this);
    }
}
