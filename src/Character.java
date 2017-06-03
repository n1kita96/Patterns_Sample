import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Created by N1kita on 07.03.2017.
 */
public class Character extends Pane{
    private Image characterImg = new Image(getClass().getResourceAsStream("2.png"));
    private ImageView imageView = new ImageView(characterImg);
    private int count = 4;
    private int columns = 4;
    private int offsetX = 0;
    private int offsetY = 96;
    private int width = 32;
    private int height = 48;
    public SpriteAnimation animation;

    public Character(){
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(this.imageView,Duration.millis(200),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(this.imageView);
    }

    public void moveX(int value){
        boolean movingRight = value > 0;
        for(int i = 0; i < Math.abs(value); i++) {
            for (Wall wall : Walls.walls) {
                if(this.getBoundsInParent().intersects(wall.getBoundsInParent())) {
                    if (movingRight) {
                        if (this.getTranslateX() + WindowView.PLAYER_SIZE == wall.getTranslateX()){
                            this.setTranslateX(this.getTranslateX() - 1);
                            wall.interaction();
                            return;
                        }
                    } else {
                        if (this.getTranslateX() == wall.getTranslateX() + WindowView.BLOCK_SIZE) {
                            this.setTranslateX(this.getTranslateX() + 1);
                            wall.interaction();
                            return;
                        }
                    }
                }
            }
            this.setTranslateX(this.getTranslateX() + (movingRight ? 1 : -1));
        }
    }
    public void moveY(int value){
        boolean movingDown = value > 0;
        for(int i = 0; i < Math.abs(value); i++){
            for(Wall wall :Walls.walls){
                if(getBoundsInParent().intersects(wall.getBoundsInParent())){
                    if(movingDown){
                        if(this.getTranslateY()+ WindowView.PLAYER_SIZE == wall.getTranslateY()){
                            this.setTranslateY(this.getTranslateY()-1);
                            wall.interaction();
                            return;
                        }
                    } else{
                        if(this.getTranslateY() == wall.getTranslateY()+ WindowView.BLOCK_SIZE){
                            this.setTranslateY(this.getTranslateY()+1);
                            wall.interaction();
                            return;
                        }
                    }
                }
            }
            this.setTranslateY(this.getTranslateY() + (movingDown?1:-1));
        }
    }

}

