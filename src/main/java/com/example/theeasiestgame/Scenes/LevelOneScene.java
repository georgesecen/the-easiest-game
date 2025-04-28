package com.example.theeasiestgame.Scenes;

import com.example.theeasiestgame.Player1;
import com.example.theeasiestgame.Panes.LevelOnePane;
import javafx.scene.Scene;

public class LevelOneScene extends Scene {
    public LevelOneScene() {
        super(new LevelOnePane(), 1024,768);
        this.getRoot().requestFocus();
    }
}
