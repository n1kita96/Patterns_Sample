/**
 * Created by N1kita on 15.03.2017.
 */
public class CryWallFactory implements WallFactory{

    public CryWall createWall(int x, int y){
        return new CryWallImpl(x, y);
    }


}
