import java.awt.*;

public class DealButton extends NewButton {

    DealButton(int x, int y, int height, int width, Component inputSource) {
        super(x, y, height, width, inputSource);
    }

    @Override
    void clickevent() {
        eventstarted = false;
    }
}
