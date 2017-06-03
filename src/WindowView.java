import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.HashMap;

/**
 * Created by N1kita on 18.05.2017.
 */
public class WindowView extends Application implements View {

    private HashMap<KeyCode,Boolean> keys = new HashMap<>();

    Image backgroundImg = new Image("images.jpg");
    public static final int BLOCK_SIZE = 45;
    public static final int PLAYER_SIZE = 40;

    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();

    public Character player;
    int levelNumber = 0;
    private int levelWidth;
    private int levelHeight;

    Helper cryHelper;
    Helper colorfulHelper;

    public void initContent(){

        /** Chain of responsibility */
        cryHelper = new CryHelper();
        colorfulHelper = new ColorfulHelper();
        cryHelper.setNext(colorfulHelper);

        WallFactory wallFactory;

        /**Strategy*/
        StrategyClient strategyClient = new StrategyClient();

        ImageView backgroundIV = new ImageView(backgroundImg);
        backgroundIV.setFitHeight(16*BLOCK_SIZE);
        backgroundIV.setFitWidth(20*BLOCK_SIZE);

        levelWidth = LevelData.levels[levelNumber][0].length()*BLOCK_SIZE;
        levelHeight = LevelData.levels[levelNumber].length *BLOCK_SIZE;

        for(int i = 0; i < LevelData.levels[levelNumber].length; i++){
            String line = LevelData.levels[levelNumber][i];
            for(int j = 0; j < line.length();j++){
                switch (line.charAt(j)) {
                    case '0':
                        wallFactory = null;
                        break;
                    case '1':
//                        wallFactory = new ColorfulWallFactory();
                        /** Decorator pattern example */
                        wallFactory = new RedFrameDecorator(new ColorfulWallFactory());
//                        wallFactory = new RotateDecorator(new ColorfulWallFactory());
//                        wallFactory = new RotateDecorator(new RedFrameDecorator(new ColorfulWallFactory()));
                        break;
                    case '2':
                        wallFactory = new CryWallFactory();
                        break;
                    case '3':
                        new Door(j * BLOCK_SIZE, i * BLOCK_SIZE);
                        wallFactory = null;
                        break;
                    default:
                        wallFactory = null;
                }

                if(wallFactory != null){
                    wallFactory.createWall(j * BLOCK_SIZE, i * BLOCK_SIZE);
                }
            }

        }


        /** Chain of Responsibility example **/
//        for (Wall wall : Walls.walls) {
//            wall.setOnMouseClicked(event -> cryHelper.showMessage(wall));
//        }

        /** Command pattern example **/
//        for (Wall wall : Walls.walls){
//            wall.setOnMouseClicked(event -> wall.wallHelperCommand());
//        }


        /**Strategy pattern example*/
//        strategyClient.setStrategy(new FillStrategy());
//        strategyClient.setStrategy(new CenterFillStrategy());
//        strategyClient.setStrategy(new LeftToRightFillStrategy());
//        for (Wall w : Walls.walls){
//            strategyClient.execute(w);
//        }

        player = new Character();
        player.setTranslateX(0);
        player.setTranslateY(15 * BLOCK_SIZE + 5);

        gameRoot.getChildren().add(player);
        appRoot.getChildren().addAll(backgroundIV,gameRoot);

        /** Iterator pattern example */
//        Walls walls = new Walls();
//        Iterator it = walls.getIterator();
//        while (it.hasNext()) {
//            Wall wall = (Wall) it.next();
//            if (wall instanceof ColorfulWall) {
//                wall.wallIV.setViewport(new Rectangle2D(16, 0 * 16, 16, 16));
//            }
//        }
    }


    private void update(){

        if(isPressed(KeyCode.UP) && player.getTranslateY()>=5){
            player.animation.setOffsetY(144);
            player.animation.setOffsetX(0);
            player.setScaleY(1);
            player.animation.play();
            player.moveY(-5);
        }
        if(isPressed(KeyCode.DOWN) && player.getTranslateY() + PLAYER_SIZE <= levelHeight - 5){
            player.animation.setOffsetX(0);
            player.animation.setOffsetY(0);
            player.setScaleY(1);
            player.animation.play();
            player.moveY(5);
        }
        if(isPressed(KeyCode.LEFT) && player.getTranslateX()>=5){
            player.animation.setOffsetY(96);
            player.animation.setOffsetX(0);
            player.setScaleX(-1);
            player.animation.play();
            player.moveX(-5);
        }
        if(isPressed(KeyCode.RIGHT) && player.getTranslateX() + PLAYER_SIZE <= levelWidth - 5) {
            player.animation.setOffsetY(96);
            player.animation.setOffsetX(0);
            player.setScaleX(1);
            player.animation.play();
            player.moveX(5);
        }

    }
    private boolean isPressed(KeyCode key){
        return keys.getOrDefault(key,false);
    }

    public void setView(){
        System.out.println("Set window view");
        try {
            start(new Stage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start(Stage primaryStage) throws Exception {
        initContent();
        Scene scene = new Scene(appRoot,levelWidth,levelHeight);
        scene.setOnKeyPressed(event-> keys.put(event.getCode(), true));

        scene.setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
            player.animation.stop();
        });
        primaryStage.setTitle("Simple Labyrinth");
        primaryStage.setScene(scene);
        primaryStage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }

}
