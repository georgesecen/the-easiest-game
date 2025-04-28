package com.example.theeasiestgame.Scenes;

import com.example.theeasiestgame.Const;
import com.example.theeasiestgame.Panes.SettingsPane;
import javafx.scene.Scene;

public class SettingsScene extends Scene {

    public SettingsScene(){
        super(new SettingsPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}