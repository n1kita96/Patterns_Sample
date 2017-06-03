import javafx.scene.Node;

/**
 * Created by N1kita on 22.05.2017.
 */
public class CryHelper extends Helper {

    public void showMessage(Node node) {
        if(node instanceof CryWall){
            System.out.println("***I'm angry CRY WALL!!! ARGH!!!***");
        } else if(next != null){
            next.showMessage(node);
        }

    }

}
