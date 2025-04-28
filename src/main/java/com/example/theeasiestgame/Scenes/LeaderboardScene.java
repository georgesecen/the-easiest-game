package com.example.theeasiestgame.Scenes;

import com.example.theeasiestgame.Const;
import com.example.theeasiestgame.Panes.LeaderboardPane;
import javafx.scene.Scene;

public class LeaderboardScene extends Scene {

    public LeaderboardScene(){
        super(new LeaderboardPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}