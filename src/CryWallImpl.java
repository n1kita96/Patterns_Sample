import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;


/**
 * Created by N1kita on 16.03.2017.
 */


public class CryWallImpl extends CryWall {


    private Image wallImg = new Image("smile_block.png");
    private Image wallImgAngry = new Image("angry_block.png");



    private static HashMap<Wall,Boolean> cryWalls = new HashMap<>();

    public void cry(){

        if(!cryWalls.getOrDefault(this, false)) {

            System.out.println("*ARGH!!*");

            Runnable task = () -> {
                wallIV.setImage(wallImgAngry);
                wallIV.setViewport(new Rectangle2D(0, 0, 204, 204));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                wallIV.setImage(wallImg);
                wallIV.setViewport(new Rectangle2D(0, 0, 600, 600));

                cryWalls.put(this, false);
            };

//        task.run();
            cryWalls.put(this, true);
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    public CryWallImpl(int x, int y){

        command = new ShowCryHelpCommand(new HelperReceiver());

        wallIV = new ImageView(wallImg);
        wallIV.setFitWidth(WindowView.BLOCK_SIZE);
        wallIV.setFitHeight(WindowView.BLOCK_SIZE);

        setTranslateX(x);
        setTranslateY(y);

        wallIV.setViewport(new Rectangle2D(0,0, 600, 600));

        getChildren().add(wallIV);

        Walls.walls.add(this);
        WindowView.gameRoot.getChildren().add(this);
    }



}
