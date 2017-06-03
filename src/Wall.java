import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by N1kita on 16.03.2017.
 */
public abstract class Wall extends Pane{

    public abstract void interaction();
    ImageView wallIV;
    Image wallImg;
    Command command;

    public void wallHelperCommand(){
        command.execute();
    }
}
