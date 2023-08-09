import java.util.List;

public class Player {
    public char icon;
    protected List<Integer> moves;

    public Player(char icon){
        this.icon = icon;
        moves = null;
    }

    public List<Integer> getMoves(){
        return moves;
    }

    public void updateMoves(int square) throws Exception{
        moves.add(square);
    }

}

class NonEmptySquare extends Exception{
    public NonEmptySquare(String message){
        super(message);
    }
}