
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//class BACK extends JFrame{
//    JButton b1;
//    JLabel l1;
//
//    public BACK(){
//        setTitle("COLOR FRAME");
//        setSize(400,400);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//
//        setLayout(new BorderLayout());
//        JLabel back = new JLabel(new ImageIcon("Pixel_Art_Background.jpg"));
//        add(back);
//        l1 = new JLabel("here");
//        b1 = new JButton("Button");
//        back.add(l1);
//        back.add(b1);
//        setSize(399,399);
//        setSize(400,400);
//        setVisible(true);
//    }
//}

//class PositionList{
//
//    private class Node{
//        int pos;
//        Node(int pos){
//            this.pos = pos;
//        }
//    }
//
//    public Node head;
//
//    private Node next;
//
//    public PositionList(){
//        head = null;
//        next = null;
//    }
//
//    public Node getNext() {
//        return next;
//    }
//
//    public void setNext(Node next){
//        this.next = next;
//    }
//    public void setHead(Node head) {
//        this.head = head;
//    }
//
//
//}
public class Game {
    protected Player ex = null;
    protected Player oh = null;
    public Player current = null;
    protected boolean winnerFound = false;
    protected List<List> winningPositions = new ArrayList<>(8);
    protected ArrayList<Integer> xPos = new ArrayList<>(5);
    protected ArrayList<Integer> yPos = new ArrayList<>(5);

    public Game(){
        ex = new Player('X');
        oh = new Player('O');
        setUpWinningPositions();
        pickStater();
    }

    /**
     * initializes 8 lists with 3 ints each that represent a tic-tac-toe combination
     */
    private void setUpWinningPositions(){
        List top = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List bot = Arrays.asList(7,8,9);
        List left = Arrays.asList(1,4,7);
        List midCol= Arrays.asList(2,5,8);
        List right = Arrays.asList(3,6,9);
        List leftDiagonal = Arrays.asList(1,5,9);
        List rightDiagonal = Arrays.asList(3,5,7);

        winningPositions.add(top);
        winningPositions.add(midRow);
        winningPositions.add(bot);
        winningPositions.add(left);
        winningPositions.add(midCol);
        winningPositions.add(right);
        winningPositions.add(leftDiagonal);
        winningPositions.add(rightDiagonal);

    }

    /**
     * sets the current player with random number generator
     */
    private void pickStater(){
        Random rnd = new Random();
        if (rnd.nextInt() % 3 == 0){
            current = ex;
        }else{
            current = oh;
        }
    }

    /**
     * method checks if case available first, then adds the position to list of the player's moves
     * @param position
     * @return true if was able to place the icon
     */
    public void play(String position){
        int pos = Integer.parseInt(position);
        if(current == ex){
            xPos.add(pos);
            System.out.print("Current list of x-positions: ");
            for (int posUsed: xPos){
                System.out.print(posUsed + " ");
            }
        }else{
            yPos.add(pos);
            System.out.print("Current list of y-positions: ");
            for (int posUsed: yPos){
                System.out.print(posUsed + " ");
            }
        }

        System.out.println();
        winnerFound = checkWin(current);

    }

    public boolean checkFull(){
        if(xPos.size() + yPos.size() == 9 ){
            return true;
        }
        return false;
    }

    public boolean checkWin(Player current){
        List<Integer> playerMoves = null;
        if(current == ex){
            playerMoves = xPos;
        }else{
            playerMoves = yPos;
        }

        for(List list: winningPositions){
            if(playerMoves.containsAll(list)){
                System.out.println("Winner found");
                return true;
            }
        }
        return false;

    }

    public void changeCurrent(){
        if(winnerFound){
            System.out.println("Winner was found!");
        }
        else{
            if(current == ex){
                current = oh;
            }else{
                current = ex;
            }
        }

    }
}
