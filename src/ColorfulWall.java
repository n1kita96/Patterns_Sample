/**
 * Created by N1kita on 15.03.2017.
 */
public abstract class ColorfulWall extends Wall{

    public  abstract void changeColor();

    public void interaction(){
        changeColor();
    }

}
