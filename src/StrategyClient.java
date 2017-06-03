/**
 * Created by N1kita on 25.05.2017.
 */
public class StrategyClient {
    Strategy strategy;
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    public void execute(Wall wall){
        strategy.paint(wall);
    }
}
