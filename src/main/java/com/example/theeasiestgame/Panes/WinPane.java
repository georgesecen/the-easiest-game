package com.example.theeasiestgame.Panes;

import com.example.theeasiestgame.LevelOneOOB;
import com.example.theeasiestgame.Navigation;
import com.example.theeasiestgame.Scenes.IntroScene;
import com.example.theeasiestgame.Scenes.LevelTwoScene;
import com.example.theeasiestgame.extras.SoundFxMusicPlayer;
import com.example.theeasiestgame.extras.SpecialButton;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class WinPane extends BorderPane {


    public WinPane(){
        SoundFxMusicPlayer soundFxPlayer = new SoundFxMusicPlayer();
        soundFxPlayer.levelFinish();



        Text title = new Text("Level Completed!");
        title.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        ScaleTransition st = new ScaleTransition(Duration.millis(600), title);
        st.setByX(3);
        st.setByY(3);
        st.setInterpolator(Interpolator.EASE_OUT);
        st.play();

        // Buttons
        SpecialButton menu = new SpecialButton(35, 200, Color.PALETURQUOISE, "Back to Menu", 14);
        menu.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new IntroScene());
            LevelOneOOB levelOneOOB = new LevelOneOOB();
            levelOneOOB.resetTest();
        });

        SpecialButton nextLevel = new SpecialButton(35, 200, Color.PALETURQUOISE, "Next Level", 14);
        nextLevel.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new LevelTwoScene());
        });


        // Add all buttons to VBOX
        VBox buttons = new VBox(menu, nextLevel);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        this.setTop(title);
        this.setAlignment(title, Pos.BOTTOM_CENTER);
        this.setCenter(buttons);
        this.setMargin(title, new Insets(100,30,30,30));
    }
}
