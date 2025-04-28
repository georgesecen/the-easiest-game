package com.example.theeasiestgame.Panes;

import com.example.theeasiestgame.LevelOneOOB;
import com.example.theeasiestgame.Navigation;
import com.example.theeasiestgame.Scenes.IntroScene;
import com.example.theeasiestgame.Scenes.LevelTwoScene;
import com.example.theeasiestgame.extras.SoundFxMusicPlayer;
import com.example.theeasiestgame.extras.SpecialButton;
import com.example.theeasiestgame.extras.TimeTracker;
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

import java.util.ArrayList;
import java.util.Collections;

public class WinPane2 extends BorderPane {
    public WinPane2(){
        SoundFxMusicPlayer soundFxPlayer = new SoundFxMusicPlayer();
        soundFxPlayer.levelFinish();


        Text title = new Text("Level Completed!");
        title.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        ScaleTransition st = new ScaleTransition(Duration.millis(600), title);
        st.setByX(3);
        st.setByY(3);
        st.setInterpolator(Interpolator.EASE_OUT);
        st.play();

        VBox middle = new VBox();

        // Buttons
        SpecialButton menu = new SpecialButton(35, 200, Color.PALETURQUOISE, "Back to Menu", 14);
        menu.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new IntroScene());
        });



        // Time tracker stuff
        TimeTracker timeTracker = new TimeTracker();
        int timeFinished = timeTracker.endTimer();

        int seconds = timeFinished % 60;

        int minutes = timeFinished / 60;

        // Time text
        Text time = new Text("Your time: " + minutes + " minute " + seconds + " seconds");
        time.setFont(Font.font("Courier New", FontWeight.BOLD, 26));

        middle.getChildren().add(time);

        ArrayList<Integer> timesList = timeTracker.getTimesFromFile();
        Collections.sort(timesList);
        for(int i=0; i < timesList.size(); i++){
            if(i<3){
                if(timesList.get(i) == timeFinished){
                    Text newScore = new Text("Great job! You made top 3");
                    newScore.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
                    middle.getChildren().add(newScore);
                    break;
                }
            }
        }


        // Add to VBOX
        middle.getChildren().add(menu);
        middle.setAlignment(Pos.CENTER);
        middle.setSpacing(100);
        middle.setTranslateY(-40);

        this.setTop(title);
        this.setAlignment(title, Pos.BOTTOM_CENTER);
        this.setCenter(middle);
        this.setMargin(title, new Insets(100,30,30,30));
    }
}
