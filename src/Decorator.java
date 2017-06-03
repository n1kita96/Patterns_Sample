/**
 * Created by N1kita on 22.05.2017.
 */
public abstract class Decorator implements WallFactory {
    WallFactory component;

    public Decorator(WallFactory component){
        this.component = component;
    }
}
