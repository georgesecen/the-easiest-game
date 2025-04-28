package com.example.theeasiestgame.Panes;

import com.example.theeasiestgame.Navigation;
import com.example.theeasiestgame.Scenes.IntroScene;
import com.example.theeasiestgame.extras.LeaderboardItemContainer;
import com.example.theeasiestgame.extras.SoundFxMusicPlayer;
import com.example.theeasiestgame.extras.SpecialButton;
import com.example.theeasiestgame.extras.TimeTracker;
import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderboardPane extends BorderPane {
    public LeaderboardPane(){
        SoundFxMusicPlayer soundFxPlayer = new SoundFxMusicPlayer();

        // Back button and leaderboard title
        //SpecialButton backButton = new SpecialButton(80, 100, Color.PINK, "Home", 10);
        SpecialButton backButton = new SpecialButton(35, 50, Color.LIGHTPINK, "Back", 14);
        backButton.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new IntroScene());});
        //this.getChildren().add(back);
        backButton.setAlignment(Pos.CENTER_LEFT);
        backButton.setTranslateX(15);
        backButton.setTranslateY(15);
        Text title = new Text("Best Times");
        title.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 40));
        title.setTranslateY(10);
        StackPane topElements = new StackPane();
        topElements.getChildren().addAll(backButton, title);

        // Getting list times
        TimeTracker timeTracker = new TimeTracker();
        ArrayList<Integer> timesList = timeTracker.getTimesFromFile();

        // Sorting the list from best to worst
        Collections.sort(timesList);

        // Creating vbox and adding leaderboard items
        VBox leaderBoardItems = new VBox();
        for (int i = 0; i < timesList.size(); i++) {
            if(i < 10) {
                int seconds = getSeconds(timesList.get(i));
                int minutes = getMinutes(timesList.get(i));

                // 1st place
                if (i == 0) {
                    LeaderboardItemContainer item = new LeaderboardItemContainer(70, 600, Color.LIGHTGOLDENRODYELLOW, Color.GOLD, 10, "1st", Color.GOLD, minutes, seconds);
                    hoverAnimation(item, 325, soundFxPlayer);
                    leaderBoardItems.getChildren().add(item);
                }
                // 2nd place
                else if (i == 1) {
                    LeaderboardItemContainer item = new LeaderboardItemContainer(70, 600, Color.LIGHTGREY, Color.GREY, 10, "2nd", Color.GREY, minutes, seconds);
                    hoverAnimation(item, 325, soundFxPlayer);
                    leaderBoardItems.getChildren().add(item);
                }
                // 3rd place
                else if (i == 2) {
                    LeaderboardItemContainer item = new LeaderboardItemContainer(70, 600, Color.WHEAT, Color.ORANGERED, 10, "3rd", Color.ORANGERED, minutes, seconds);
                    hoverAnimation(item, 325, soundFxPlayer);
                    leaderBoardItems.getChildren().add(item);
                }
                // Everythng else
                else {
                    LeaderboardItemContainer item = new LeaderboardItemContainer(70, 600, Color.WHITESMOKE, Color.LIGHTGREY, 10, String.valueOf(i + 1) + "th", Color.GREY, minutes, seconds);
                    hoverAnimation(item, 325, soundFxPlayer);
                    leaderBoardItems.getChildren().add(item);
                }
            }
        }





        // Adding elements to borderpane
        this.setTop(topElements);
        this.setCenter(leaderBoardItems);

        // Positioning
        leaderBoardItems.setAlignment(Pos.CENTER);
        // Making sure items stack
        leaderBoardItems.setSpacing(-20);


    }

    public int getSeconds(int seconds){ // Returns how many seconds are left after subtracting the minutes
        return seconds % 60;
    }
    public int getMinutes(int seconds){ // Returns how many minutes were in seconds time
        return seconds / 60;
    }

    public void hoverAnimation(LeaderboardItemContainer leaderboardItem, double duration, SoundFxMusicPlayer sfx){
        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(duration), leaderboardItem);
        scaleOut.setFromX(1);
        scaleOut.setFromY(1);
        scaleOut.setToX(1.25);
        scaleOut.setToY(1.25);

        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(duration), leaderboardItem);
        scaleIn.setFromX(1.25);
        scaleIn.setFromY(1.25);
        scaleIn.setToX(1);
        scaleIn.setToY(1);



        // On hover play animation
        leaderboardItem.setOnMouseEntered(e->{
            // Changes order of item kind of like z index, puts it infront of everything else
            leaderboardItem.setViewOrder(-1);
            scaleOut.play();

            // Make noise
            sfx.tapSound();
        });
        leaderboardItem.setOnMouseExited(e->{
            // Resetting view order
            leaderboardItem.setViewOrder(0);
            scaleIn.play();
        });


    }
}

