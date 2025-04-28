package com.example.theeasiestgame.Scenes;

import com.example.theeasiestgame.Panes.LevelTwoPane;
import javafx.scene.Scene;

public class LevelTwoScene extends Scene {
    public LevelTwoScene() {
        super(new LevelTwoPane(),1024,768);
        this.getRoot().requestFocus();
    }
}
