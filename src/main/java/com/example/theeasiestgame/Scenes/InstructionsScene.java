package com.example.theeasiestgame.Scenes;

import com.example.theeasiestgame.Const;
import com.example.theeasiestgame.Panes.InstructionsPane;
import javafx.scene.Scene;

public class InstructionsScene extends Scene {
    public InstructionsScene(){
        super(new InstructionsPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);}
}
