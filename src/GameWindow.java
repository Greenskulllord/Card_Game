import javax.swing.*;
import java.awt.*;
public class GameWindow extends JFrame {
    private final int SCREEN_WIDTH = 1366;
    private final int SCREEN_HEIGHT = 768;

    int hi = 1;

    GameWindow() {

        this.add(new GamePanel());

        this.setTitle("21 Card Game");
        this.setSize(this.SCREEN_WIDTH, this.SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

}
