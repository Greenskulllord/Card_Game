import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GamePanel extends JPanel implements ActionListener {

    private final int SCREEN_WIDTH = 1366;
    private final int SCREEN_HEIGHT = 768;;
    private final int UNIT_SIZE = 180;
    private final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    private NewButton drawButton;
    private int rectx = (int) (0.9 * SCREEN_WIDTH);
    private int recty = (int) (0.8 * SCREEN_HEIGHT);
    private int rsize = UNIT_SIZE / 2;

    //create the game screen, game screen/panels are different than the gameWindow
    GamePanel() {
    this.setBackground(Color.black);
    this.setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    this.setFocusable(true);

    }
    //draw everything on screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawButton(g);
        standButton(g);
    }
    int hi = 1;

    public void drawButton(Graphics r) {
        //declare variables
        this.rectx = (int) (0.9 * SCREEN_WIDTH);
        this.recty = (int) (0.8 * SCREEN_HEIGHT);
        this.rsize = UNIT_SIZE / 2;

        //create draw button frame
        r.setColor(Color.blue);
        r.fillRoundRect(rectx, recty, rsize, rsize, 3, 3);

        //turn frame into button
        new DealButton(rectx, recty, rsize, rsize, this);
    }

    public void standButton(Graphics r) {
        this.rectx = (int) (0.8 * SCREEN_WIDTH);
        this.recty = (int) (0.8 * SCREEN_HEIGHT);
        this.rsize = UNIT_SIZE / 2;

        r.setColor(Color.red);
        r.fillRoundRect(rectx, recty, rsize, rsize, 3, 3);

        new StandButton(rectx, recty, rsize, rsize, this);

    }

    public void drawGrid(Graphics g) {
        g.setColor(Color.white);

        for(int i = 0; i < GAME_UNITS; i++) {
            g.drawLine(SCREEN_WIDTH, i * UNIT_SIZE, 0 , i * UNIT_SIZE);
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hi");
    }
}


