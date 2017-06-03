import javafx.scene.Node;

/**
 * Created by N1kita on 22.05.2017.
 */
public class ColorfulHelper extends Helper {


    public void showMessage(Node node) {
        if(node instanceof ColorfulWall){
            System.out.println("***I'm fancy colorful wall***");
        } else if(next != null){
            next.showMessage(node);
        }

    }

}
