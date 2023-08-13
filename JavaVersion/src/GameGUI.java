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
        startUp.setVisible(true);
    }

    //TODO: adjust the color scheme of the 
    private static JPanel initializeButtons(JPanel panel) {
        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons.length; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setBackground(Color.GRAY);
                buttons[row][col].setOpaque(true);
                panel.add(buttons[row][col]);
            }
        }

        return panel;
    }

    /**
     * switches window from startup menu to new Tic Tac Toe gameWindow
     */
    private static void startGame() {
        startUp.setVisible(false);
        gameWindow = new JFrame("TIC-TAC-TOE");
        //Game idk = new Game();


        setUpGameStart();
        gameWindow.setLayout(new BorderLayout(10,10));
        gameWindow.setMaximumSize(new Dimension(500, 500));
        gameWindow.setMinimumSize(new Dimension(500, 500));
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(500, 500);

        gameWindow.setVisible(true);

    }

    private static void exitGame() {
        System.exit(0);
    }

    private static void setUpGameStart(){
        game = new Game();
        JPanel board = new JPanel();

        board.setBackground(Color.BLACK);
        board.setBounds(100,90,300,300);

        gameWindow.add(board);

    }

    public static void main(String[] args) {
        GameGUI g = new GameGUI();
    }

}