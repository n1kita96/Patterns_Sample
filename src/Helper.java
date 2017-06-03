import javafx.scene.Node;

/**
 * Created by N1kita on 22.05.2017.
 */

/** Chain of responsibility */
abstract class Helper {

    Helper next;

    abstract void showMessage(Node node);

    public void setNext(Helper helper){
        this.next = helper;
    }
}
