import java.awt.*;

public class StandButton extends NewButton {

    StandButton(int x, int y, int height, int width, Component inputSource) {
        super(x, y, height, width, inputSource);
    }

    @Override
    void clickevent() {
        new Stand();
        eventstarted = false;
    }
}
