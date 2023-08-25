import java.util.List;

public class Player {
    private char icon;
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

    public String getIcon(){
        return String.valueOf(icon);
    }


}
