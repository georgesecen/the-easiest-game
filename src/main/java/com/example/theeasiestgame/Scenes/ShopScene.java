package com.example.theeasiestgame.Scenes;

import com.example.theeasiestgame.Const;
import com.example.theeasiestgame.Panes.ShopPane;
import javafx.scene.Scene;

public class ShopScene extends Scene {

    public ShopScene(){
        super(new ShopPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}