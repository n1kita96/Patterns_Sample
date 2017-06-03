/**
 * Created by N1kita on 18.05.2017.
 */
public class ColorfulLabyrinth extends Labyrinth{


    public ColorfulLabyrinth(View view){
        super(view);

        StringBuilder builder;

        for (int i = 0; i < LevelData.LEVEL1.length; i++) {
            char[] cells = LevelData.LEVEL1[i].toCharArray();
            builder = new StringBuilder();
            for (int j = 0; j < cells.length; j++) {
                if(cells[j] == '2') {
                    cells[j] = '1';
                }
                builder.append(cells[j]);
            }
            LevelData.LEVEL1[i] = builder.toString();
        }
    }

    public void showType(){
        System.out.println("Colorful labyrinth");
    }
}
