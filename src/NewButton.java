import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class NewButton {
    private boolean eventstarted = false;
    private String event;

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
                    System.out.println("y" + y);
                    clickevent();
                }
            }
        });

    }

    private void clickevent() {
        eventstarted = false;
        System.out.println("hi");
    }
}
