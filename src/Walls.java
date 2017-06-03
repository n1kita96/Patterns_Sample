import java.util.ArrayList;

/**
 * Created by N1kita on 24.05.2017.
 */

/**Iterator*/

public class Walls implements Container {

    public static ArrayList<Wall> walls = new ArrayList<>();

    public Iterator getIterator() {
        return new WallIterator();
    }

    private class WallIterator implements Iterator{

        int index = 0;

        public boolean hasNext() {
            return index < walls.size();
        }

        public Object next() {
            return walls.get(index++);
        }
    }

}
