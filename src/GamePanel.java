import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GamePanel extends JPanel implements ActionListener {

    private final int SCREEN_WIDTH = 1366;
    private final int SCREEN_HEIGHT = 768;;
    private final int UNIT_SIZE = 180;
    private final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    private final boolean GAME_START;

    GamePanel() {
    this.setBackground(Color.black);
    this.setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    this.setFocusable(true);
    this.GAME_START = true;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        DrawCardButton(g);
    }

    public void drawGrid(Graphics g) {
        g.setColor(Color.white);

        for(int i = 0; i < GAME_UNITS; i++) {
            g.drawLine(SCREEN_WIDTH, i * UNIT_SIZE, 0 , i * UNIT_SIZE);
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
        }



    }

    public void DrawCardButton(Graphics r) {
        int rectx = (int) (0.9 * SCREEN_WIDTH);
        int recty = (int) (0.8 * SCREEN_HEIGHT);
        int rsize = UNIT_SIZE / 2;

        r.setColor(Color.blue);
        r.fillRoundRect(rectx, recty, rsize, rsize, 3, 3);

        NewButton button;
        button = new NewButton(rectx, recty, rsize, rsize, this);
    }

    public void card() {


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
