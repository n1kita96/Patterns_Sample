
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Created by N1kita on 07.03.2017.
 */

public class Game extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        /**Bridge pattern example*/
        Labyrinth labyrinth = new MixedLabyrinth(new WindowView());
//        Labyrinth labyrinth = new ColorfulLabyrinth(new WindowView());
//        Labyrinth labyrinth = new CryLabyrinth(new ConsoleView());
//        Labyrinth labyrinth = new MixedLabyrinth(new ConsoleView());
        labyrinth.show();

        /** Adapter pattern example*/
//        Labyrinth labyrinth1 = new Adapter(new ConsoleView());
//        labyrinth1.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}