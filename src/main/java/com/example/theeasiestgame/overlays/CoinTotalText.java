package com.example.theeasiestgame.overlays;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CoinTotalText extends Text {
    private final Text coinCountText;
    public CoinTotalText() {
        coinCountText = new Text();
        coinCountText.setFont(Font.font("Sans-serif", 25));
        Stop[] stops = new Stop[] { new Stop(0, Color.GREEN), new Stop(1, Color.RED)};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        coinCountText.setFill(lg1);
    }

    public Text getCoinCountText() {
        return coinCountText;
    }
}
