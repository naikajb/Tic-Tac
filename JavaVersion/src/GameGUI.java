import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;


public class GameGUI implements Serializable {

    private static JButton[][] buttons = new JButton[3][3];
    private static JFrame gameWindow = null;
    private static JFrame startUp = null;
    private static Game game = null;
    JPanel GamePanel = null;


    public GameGUI() {
        startUp = new JFrame("TIC-TAC-TOE");
        //gameWindow = new JFrame("TIC-TAC-TOE");
        setUpOpeningPanel();
//        JPanel OpeningPanel = setUpOpeningPanel();
//        JPanel GamePanel = new JPanel();
//
//        gameWindow.add(OpeningPanel);
//
//        //initializeButtons(GamePanel);
//        GamePanel.setLayout(new GridLayout(3,3));
//        gameWindow.setMaximumSize(new Dimension(500,500));
//        gameWindow.setMinimumSize(new Dimension(500,500));
//        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //gameWindow.add(GamePanel);
//        gameWindow.setVisible(true);
    }

    /**
     * sets up the starting menu
     */
    private void setUpOpeningPanel() {
        startUp = new JFrame();

        JButton start = new JButton("NEW GAME");
        JButton resume = new JButton("RESUME");
        JButton exit = new JButton("EXIT");

        start.setBounds(200, 160, 100, 40);
        resume.setBounds(200, 210, 100, 40);
        exit.setBounds(400, 430, 90, 30);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        startUp.add(start);

        //TODO implement resuming gameWindow
        resume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        startUp.add(resume);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitGame();
            }
        });
        startUp.add(exit);

        startUp.setSize(500, 500);
        startUp.setLayout(null);
        startUp.setMaximumSize(new Dimension(500, 500));
        startUp.setMinimumSize(new Dimension(500, 500));
        startUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startUp.setLocationRelativeTo(null);
        startUp.setVisible(true);
    }


    /**
     * switches window from startup menu to new Tic Tac Toe gameWindow
     */
    private static void startGame() {
        startUp.setVisible(false);
        gameWindow = new JFrame("TIC-TAC-TOE");

        setUpGameStart();
        gameWindow.setLayout(new BorderLayout(10,10));
        gameWindow.setMaximumSize(new Dimension(500, 500));
        gameWindow.setMinimumSize(new Dimension(500, 500));
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(500, 500);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);

    }

    private static void exitGame() {
        System.exit(0);
    }

    /**
     * sets up the buttons for the game in a JPanel
     */
    private static void setUpGameStart(){
        game = new Game();

        JPanel board = new JPanel();
        board.setLayout(new GridLayout(3,3));
        board.setBackground(Color.BLACK);
        board.setBounds(100,90,300,300);
        int count = 0;
        for (int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                count++;
                buttons[row][col] = new JButton(String.valueOf(count));
                buttons[row][col].setForeground(Color.RED);
                buttons[row][col].setOpaque(true);
                buttons[row][col].setFocusable(false);//makes it not be "highlighted" when you click on it
                addAction(buttons[row][col]);
                board.add(buttons[row][col]);
            }
        }
        gameWindow.add(board);
    }

    /**
     * Method to place the player's tokens on the squares
     * @param button
     */
    private static void addAction(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(game.current == game.ex){
                    game.play(button.getText());
                    //TODO place icon  on square
                    button.setText(game.ex.getIcon());
                    button.setFont(new Font("Arial",3,40));

                    //disables button after placing piece
                    button.setEnabled(false);
                }else{
                    game.play(button.getText());
                   // int fine = game.checkWin(game.current);
                   // System.out.println(fine);
                    //TODO place icon on square
                    button.setText(game.oh.getIcon());
                    button.setFont(new Font("Arial", Font.BOLD,40));

                    //disables button after placing piece
                    button.setEnabled(false);
                    //TODO check if player won
                }

                if (!game.winnerFound){
                    boolean over = game.checkFull();
                    if(over){
                        System.out.println("No body wins. Try again!");
                    }else{
                        game.changeCurrent();
                    }
                }else{
                    for(int i = 0; i < buttons.length; i++){
                        for(int j = 0; j < buttons.length; j++){
                            buttons[i][j].setEnabled(false);
                        }
                    }
                    System.out.println(game.current.getIcon() + " wins!");

                }
            }
        });
    }

    public static void main(String[] args) {
        GameGUI g = new GameGUI();
    }

}