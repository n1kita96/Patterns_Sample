/**
 * Created by N1kita on 18.05.2017.
 */
public class ConsoleView implements View {

    public void setView(){
        System.out.println("Set console view");
        System.out.println();

        for (int i = 0; i < LevelData.LEVEL1.length; i++) {
            System.out.println(LevelData.LEVEL1[i]);
        }

    }
}
