import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

/**
 * Created by N1kita on 16.03.2017.
 */
public class ColorfulWallImpl extends ColorfulWall{

    private Image wallImg = new Image("colorful_block.png");

    public ColorfulWallImpl(int x, int y){

        command = new ShowColorfulHelpCommand(new HelperReceiver());

        wallIV = new ImageView(wallImg);
        wallIV.setFitWidth(WindowView.BLOCK_SIZE);
        wallIV.setFitHeight(WindowView.BLOCK_SIZE);

        setTranslateX(x);
        setTranslateY(y);

        int random = getRandom(0, 8);
        wallIV.setViewport(new Rectangle2D(16,random * 16, 16, 16));
        getChildren().add(wallIV);

        Walls.walls.add(this);
        WindowView.gameRoot.getChildren().add(this);
    }

    public void changeColor(){
        int random = getRandom(0,8);
        wallIV.setViewport(new Rectangle2D(16, random * 16, 16, 16));
    }

    private int getRandom(int min, int max){
        Random r = new Random();
        return r.nextInt(max - min);//+1;
    }
}
