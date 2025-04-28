package com.example.theeasiestgame.Panes;

import com.example.theeasiestgame.Navigation;
import com.example.theeasiestgame.Scenes.IntroScene;
import com.example.theeasiestgame.extras.BackgroundMusicPlayer;
import com.example.theeasiestgame.extras.SongContainer;
import com.example.theeasiestgame.extras.SoundFxMusicPlayer;
import com.example.theeasiestgame.extras.SpecialButton;
import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

public class SettingsPane extends BorderPane {
    public SettingsPane() {

        // Creating  music players
        BackgroundMusicPlayer backgroundMusicPlayer = new BackgroundMusicPlayer();
        SoundFxMusicPlayer soundFxPlayer = new SoundFxMusicPlayer();


        // Back button and settings title
//        SpecialButton backButton = new SpecialButton(80, 100, Color.PINK, "Home", 10);
        SpecialButton backButton = new SpecialButton(35, 50, Color.LIGHTPINK, "Back", 14);
        backButton.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new IntroScene());});
        backButton.setAlignment(Pos.CENTER_LEFT);
        backButton.setTranslateX(15);
        backButton.setTranslateY(15);
        Text title = new Text("Settings");
        title.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 40));
        title.setTranslateY(10);
        StackPane topElements = new StackPane();
        topElements.getChildren().addAll(backButton, title);


        // Getting a list of background music file names
        File[] backgroundMusicFiles = new File("Media/backgroundMusic").listFiles();
        ArrayList<String> songFileNames = new ArrayList<>();
        for (File songFile : backgroundMusicFiles) {
            songFileNames.add(songFile.getName());
        }

        // Creating list of song container items
        ArrayList<SongContainer> songContainersList = new ArrayList<>();
        for (String songFileName : songFileNames) {
            songContainersList.add(new SongContainer(songFileName, 30, 200, Color.DEEPSKYBLUE, Color.TRANSPARENT, 10, 20));
        }

        // Creating vbox and adding song containers
        VBox songContainersVbox = new VBox();
        for (SongContainer songContainer : songContainersList) {
            songContainersVbox.getChildren().add(songContainer);
        }

        // Creating vbox and adding up down buttons
        VBox songButtons = new VBox();
        SpecialButton downButton = new SpecialButton(90, 90, Color.DEEPSKYBLUE,"⬆", 30);
        SpecialButton upButton = new SpecialButton(90, 90, Color.DEEPSKYBLUE,"⬇", 30);
        songButtons.getChildren().addAll(downButton, upButton);

        // Creating vbox and adding background mute buttons
        VBox backgroundMuteArea = new VBox();
        Text backgroundMusicText = new Text("Background Music");
        backgroundMusicText.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 20));
        String backgroundMusicSymbol = "";
        if(backgroundMusicPlayer.getOnStatus()){
            backgroundMusicSymbol = "ON";
        }
        else{
            backgroundMusicSymbol = "OFF";
        }
        SpecialButton backgroundMusicMuteButton = new SpecialButton(100, 100, Color.DEEPSKYBLUE,backgroundMusicSymbol, 20);
        backgroundMuteArea.getChildren().addAll(backgroundMusicText, backgroundMusicMuteButton);

        // Creating vbox and adding soundfx mute buttons
        VBox soundFxMuteArea = new VBox();
        Text soundFxMusicText = new Text("Sound FX");
        soundFxMusicText.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 20));
        String soundFxSymbol = "";
        if(soundFxPlayer.getOnStatus()){
            soundFxSymbol = "ON";
        }
        else{
            soundFxSymbol = "OFF";
        }
        SpecialButton soundFxMusicMuteButton = new SpecialButton(100, 100, Color.DEEPSKYBLUE,soundFxSymbol, 20);
        soundFxMuteArea.getChildren().addAll(soundFxMusicText, soundFxMusicMuteButton);

        //Creating vbox which will store mute area
        VBox muteSoundsArea = new VBox();
        muteSoundsArea.getChildren().addAll(backgroundMuteArea, soundFxMuteArea);

        // Creating hbox which will store everything for center border
        HBox mainArea = new HBox();
        mainArea.getChildren().addAll(muteSoundsArea, songContainersVbox, songButtons);

        // Positioning everything
        mainArea.setAlignment(Pos.BOTTOM_CENTER);
        mainArea.setSpacing(30);
        mainArea.setTranslateX(-40);
        mainArea.setTranslateY(100);

        songContainersVbox.setSpacing(25);

        songButtons.setAlignment(Pos.CENTER);
        songButtons.setTranslateY(-100);
        songButtons.setTranslateX(100);
        songButtons.setSpacing(5);

        muteSoundsArea.setAlignment(Pos.CENTER);
        muteSoundsArea.setSpacing(50);
        muteSoundsArea.setTranslateY(-100);
        muteSoundsArea.setTranslateX(-100);

        soundFxMusicText.setTranslateX(50);




        // Creating the carosel thingy
        final int[] centerItem = {4};
        int start = 0;
        for (SongContainer container : songContainersList) {
            container.setOpacity(0);
            // Item in middle
            if(start == centerItem[0]){
                container.setOpacity(1);
                container.setScaleX(2);
                container.setScaleY(2);
            }
            // Item on bottom
            else if(start == centerItem[0] - 1){
                container.setOpacity(0.3);
            }
            // Item on top
            else if(start == centerItem[0] + 1){
                container.setOpacity(0.3);
            }
            // Space out items
            else{
                if(start < centerItem[0]){
                    int distanceToCenterItem = ((centerItem[0] - start) * 20) - 40;
                    container.setTranslateY(distanceToCenterItem);
                }
                if(start > centerItem[0]){
                    int distanceToCenterItem = ((start -centerItem[0]) * 20) - 40;
                    container.setTranslateY(-distanceToCenterItem);
                }

            }

            start++;
        }







//        // Creating  music players
//        BackgroundMusicPlayer backgroundMusicPlayer = new BackgroundMusicPlayer();
//        SoundFxMusicPlayer soundFxMusicPlayer = new SoundFxMusicPlayer();

        // Volume button actions
        soundFxMusicMuteButton.button.setOnAction(e->{
            soundFxPlayer.clickSound();
            // Changing button icon and stopping music
            if(soundFxPlayer.getOnStatus()){
                soundFxMusicMuteButton.setButtonText("OFF");
                soundFxPlayer.stopPlaying();
                soundFxPlayer.turnOffPlayer();
            }
            else {
                // Changing icon
                soundFxMusicMuteButton.setButtonText("ON");
                soundFxPlayer.turnOnPlayer();
            }

        });
        backgroundMusicMuteButton.button.setOnAction(e->{
            soundFxPlayer.clickSound();
            // Changing button icon and stopping music
            if(backgroundMusicPlayer.isPlaying()){
                backgroundMusicMuteButton.setButtonText("OFF");
                backgroundMusicPlayer.stopPlaying();
                backgroundMusicPlayer.turnOffPlayer();
            }
            else{
                // Changing icon
                backgroundMusicMuteButton.setButtonText("ON");

                // Getting the currently focused song file and playing it
                backgroundMusicPlayer.turnOnPlayer();
                String currentlyFocusedSong = songFileNames.get(centerItem[0]);
                File songFile = new File("Media/backgroundMusic/" + currentlyFocusedSong);
                backgroundMusicPlayer.playMusicFromFile(songFile);
            }
        });
        downButton.button.setOnAction(e->{
            soundFxPlayer.clickSound();
            if(centerItem[0] > 0){
                animateSongsUp(centerItem[0], songContainersList, 0, 250, 30);
                centerItem[0]--;
            }
            // Getting the currently focused song file and playing it
            String currentlyFocusedSong = songFileNames.get(centerItem[0]);
            File songFile = new File("Media/backgroundMusic/" + currentlyFocusedSong);
            backgroundMusicPlayer.playMusicFromFile(songFile);

        });

        upButton.button.setOnAction(e->{
            soundFxPlayer.clickSound();
            if(centerItem[0] < songContainersList.size() - 1){
                animateSongsDown(centerItem[0], songContainersList, 1, 250, 30);
                centerItem[0]++;
            }
            // Getting the currently focused song file and playing it
            String currentlyFocusedSong = songFileNames.get(centerItem[0]);
            File songFile = new File("Media/backgroundMusic/" + currentlyFocusedSong);
            backgroundMusicPlayer.playMusicFromFile(songFile);
        });



        // Adding elements to borderpane
        this.setTop(topElements);
        this.setCenter(mainArea);
    }

    public void animateSongsUp(int centerItem, ArrayList<SongContainer> list, int direction, double duration, double translateBy){
        for (int i = 0; i < list.size(); i++) {
            if(i == centerItem - 2){
                songAppear(list.get(i), direction, duration, translateBy);
            }
            else if(i == centerItem - 1){
                songFadeIn(list.get(i), direction, duration, translateBy);
            }
            else if(i == centerItem){
                songFadeOut(list.get(i), direction, duration, translateBy);
            }
            else if(i == centerItem + 1){
                songDisapear(list.get(i), direction, duration, translateBy);
            }
            else{
//                list.get(i).setY(100);
//                System.out.println("fdi");
            }
        }
    }

    public void animateSongsDown(int centerItem, ArrayList<SongContainer> list, int direction, double duration, double translateBy){
        for (int i = 0; i < list.size(); i++) {
            if(i == centerItem - 1){
                songDisapear(list.get(i), direction, duration, translateBy);
            }
            if(i == centerItem){
                songFadeOut(list.get(i), direction, duration, translateBy);
            }
            if(i == centerItem + 1){
                songFadeIn(list.get(i), direction, duration, translateBy);
            }
            if(i == centerItem + 2){
                songAppear(list.get(i), direction, duration, translateBy);
            }


        }
    }

    // 0 for up 1 for down
    public void songFadeOut(SongContainer node, int direction, double duration, double translateBy){
        FadeTransition fadeOut = new FadeTransition(Duration.millis(duration), node);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0.3);

        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(duration), node);
        scaleIn.setFromX(2);
        scaleIn.setFromY(2);
        scaleIn.setToX(1);
        scaleIn.setToY(1);

        TranslateTransition translateOut = new TranslateTransition(Duration.millis(duration), node);
        if(direction == 0){
             translateOut.setByY(translateBy);
        }
        else{
            translateOut.setByY(-translateBy);
        }

        ParallelTransition parallelAnimations = new ParallelTransition();
        parallelAnimations.getChildren().addAll(
                translateOut,
                fadeOut,
                scaleIn
        );
        parallelAnimations.play();
    }

    public void songFadeIn(SongContainer node, int direction, double duration, double translateBy){
        FadeTransition fadeIn = new FadeTransition(Duration.millis(duration), node);
        fadeIn.setFromValue(0.3);
        fadeIn.setToValue(1);


        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(duration), node);
        scaleOut.setFromX(1);
        scaleOut.setFromY(1);
        scaleOut.setToX(2);
        scaleOut.setToY(2);


        TranslateTransition translateIn = new TranslateTransition(Duration.millis(duration), node);
        if(direction == 0){
             translateIn.setByY(translateBy);
        }
        else{
            translateIn.setByY(-translateBy);
        }

        ParallelTransition parallelAnimations = new ParallelTransition();
        parallelAnimations.getChildren().addAll(
                translateIn,
                fadeIn,
                scaleOut

        );
        parallelAnimations.play();

    }

    public void songDisapear(SongContainer node, int direction, double duration, double translateBy){
        FadeTransition fadeOut = new FadeTransition(Duration.millis(duration), node);
        fadeOut.setFromValue(0.3);
        fadeOut.setToValue(0);

        TranslateTransition translateOut = new TranslateTransition(Duration.millis(duration), node);
        if(direction == 0){
             translateOut.setByY(translateBy);
        }
        else{
            translateOut.setByY(-translateBy);
        }

        ParallelTransition parallelAnimations = new ParallelTransition();
        parallelAnimations.getChildren().addAll(
                fadeOut,
                translateOut
        );
        parallelAnimations.play();
    }

    public void songAppear(SongContainer node, int direction, double duration, double translateBy){
        FadeTransition fadeIn = new FadeTransition(Duration.millis(duration), node);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(0.3);

        TranslateTransition translateIn = new TranslateTransition(Duration.millis(duration), node);
        if(direction == 0){
             translateIn.setByY(translateBy);
        }
        else{
            translateIn.setByY(-translateBy);
        }

        ParallelTransition parallelAnimations = new ParallelTransition();
        parallelAnimations.getChildren().addAll(
                fadeIn,
                translateIn
        );
        parallelAnimations.play();
    }

}