/**
 * Created by N1kita on 22.05.2017.
 */
public class Adapter extends Labyrinth{

    OtherLabyrinth otherLabyrinth = new OtherLabyrinth(view);

    public Adapter(View view) {
        super(view);
    }

    public void showType() {
        otherLabyrinth.showTypeOther();
    }

    public void show(){
        otherLabyrinth.showOther();
    }
}
