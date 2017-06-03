/**
 * Created by N1kita on 18.05.2017.
 */
public abstract class Labyrinth {

    View view;

    public Labyrinth(View view){
        this.view = view;
    }
    public abstract void showType();

    public void show(){
        showType();
        view.setView();
    }

}
