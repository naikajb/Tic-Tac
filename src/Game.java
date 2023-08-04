
import javax.swing.JFrame;
import java.util.List;
import java.util.Random;
//import java.util.random;


public class Game {
    protected Player ex = null;
    protected Player oh = null;
    protected Player current = null;
    protected boolean winnerFound = false;

    protected List<Integer> X_moves = null;
    protected List<Integer> O_moves = null;

    public Game(){
        ex = new Player('X');
        oh = new Player('O');
        pickStater();

        while(!winnerFound){
            X_moves.add(play(current));
        }

    }

    /**
     * sets the current player with random number
     */
    private void pickStater(){
        Random rnd = new Random();

        if (rnd.nextInt() % 3 == 0){
            current = ex;
        }else{
            current = oh;
        }
    }

    private int play(Player current){
        return 0;
    }
}
