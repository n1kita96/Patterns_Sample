/**
 * Created by N1kita on 22.05.2017.
 */

/**
 * For adapter pattern example
 */

public class OtherLabyrinth {
    View view;

    public OtherLabyrinth(View view){
        this.view = view;
    }

    public void showTypeOther(){
        System.out.println("I'm other labyrinth!");
    }

    public void showOther(){
        showTypeOther();
        view.setView();
    }

}
