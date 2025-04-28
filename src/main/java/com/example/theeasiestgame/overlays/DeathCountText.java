package com.example.theeasiestgame.overlays;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DeathCountText extends Text {
    private final Text deathCountText;
    public DeathCountText() {
        deathCountText = new Text();
        deathCountText.setFont(Font.font("Sans-serif", 25));
    }

    public Text getDeathCountText() {
        return deathCountText;
    }
}
