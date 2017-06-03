/**
 * Created by N1kita on 16.03.2017.
 */
public class ColorfulWallFactory implements WallFactory {

    public ColorfulWall createWall(int x, int y){
        return new ColorfulWallImpl(x, y);
    }


}
