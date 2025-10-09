import java.awt.*;

public class StandButton extends NewButton {

    StandButton(int x, int y, int height, int width, Component inputSource) {
        super(x, y, height, width, inputSource);
    }
    int hi = 1;
    @Override
    void clickevent() {
        new Stand();
        eventstarted = false;
    }
}
