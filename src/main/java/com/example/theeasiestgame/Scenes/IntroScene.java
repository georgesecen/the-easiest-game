package com.example.theeasiestgame.Scenes;

import com.example.theeasiestgame.Const;
import com.example.theeasiestgame.Panes.IntroPane;
import javafx.scene.Scene;

public class IntroScene extends Scene {
    public IntroScene(){
        super(new IntroPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
