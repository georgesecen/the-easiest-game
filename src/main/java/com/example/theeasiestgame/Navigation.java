package com.example.theeasiestgame;

import com.example.theeasiestgame.Scenes.IntroScene;
import com.example.theeasiestgame.Scenes.LevelOneScene;
import com.example.theeasiestgame.Scenes.LevelTwoScene;
import com.example.theeasiestgame.Scenes.WinScene2;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation extends Application {

    public static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        mainStage.setTitle("The Easiest Game!");
        mainStage.setScene(new IntroScene());
        mainStage.show();
        mainStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}