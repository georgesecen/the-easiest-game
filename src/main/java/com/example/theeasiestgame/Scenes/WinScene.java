package com.example.theeasiestgame.Scenes;

import com.example.theeasiestgame.Const;
import com.example.theeasiestgame.Panes.WinPane;
import javafx.scene.Scene;

public class WinScene extends Scene {
    public WinScene(){super(new WinPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);}
}
