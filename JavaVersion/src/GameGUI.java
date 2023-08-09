import javax.swing.*;
import java.awt.*;


public class GameGUI  {

    JButton[][] buttons = new JButton[3][3];
    public GameGUI(){
        JFrame game = new JFrame("TIC-TAC-TOE");
        JPanel OpeningPanel = setUpOpeningPanel();
        JPanel GamePanel = new JPanel();

        game.add(OpeningPanel);

        //initializeButtons(GamePanel);
        GamePanel.setLayout(new GridLayout(3,3));
        game.setMaximumSize(new Dimension(500,500));
        game.setMinimumSize(new Dimension(500,500));
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //game.add(GamePanel);
        game.setVisible(true);

    }

    public JPanel setUpOpeningPanel(){
        JPanel panel = new JPanel();
        ImageIcon bgrnd = new ImageIcon("background.png");
        JLabel idk = new JLabel(bgrnd);

        //panel.add(bgrnd);
        return panel;
    }

    //TODO: adjust the color scheme of the 
    public void initializeButtons(JPanel panel){
        for (int row = 0; row < buttons.length; row++){
            for(int col = 0; col < buttons.length; col++){
                buttons[row][col] = new JButton();
                buttons[row][col].setBackground(Color.GRAY);
                buttons[row][col].setOpaque(true);
                panel.add(buttons[row][col]);
            }
        }
    }
    public static void main(String[] args) {
        GameGUI g = new GameGUI();
    }

}