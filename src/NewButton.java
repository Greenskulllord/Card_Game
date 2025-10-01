import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public abstract class NewButton {
    boolean eventstarted = false;
    /**
     * int x
     * int y
     * int width
     * int height
     */
    NewButton(int x, int y, int height, int width, Component inputSource) {

        inputSource.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(e.getX() >= x && e.getX() <= x + width && e.getY() >= y && e.getY() <= y + height) {
                    eventstarted = true;
                    clickevent();
                }
            }
        });

    }

    void clickevent() {
        eventstarted = false;
    }

}
