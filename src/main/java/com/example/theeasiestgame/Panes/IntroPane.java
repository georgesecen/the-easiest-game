package com.example.theeasiestgame.Panes;

import com.example.theeasiestgame.Navigation;
import com.example.theeasiestgame.Scenes.*;
import com.example.theeasiestgame.extras.BackgroundMusicPlayer;
import com.example.theeasiestgame.extras.SoundFxMusicPlayer;
import com.example.theeasiestgame.extras.SpecialButton;
import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;

public class IntroPane extends BorderPane {

    public IntroPane(){
        // Set title
        Navigation.mainStage.setTitle("The Easiest Game!");

        // sound
        BackgroundMusicPlayer backgroundMusicplayer = new BackgroundMusicPlayer();
        SoundFxMusicPlayer soundFxPlayer = new SoundFxMusicPlayer();
        if(!backgroundMusicplayer.isPlaying()){
            backgroundMusicplayer.playMusicFromFile(new File("Media/backgroundMusic/8bit-music-for-game-68698.mp3"));
            backgroundMusicplayer.getPlayer().setCycleCount(MediaPlayer.INDEFINITE);
        }


        Text title = new Text("The Easiest Game");
        title.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        ScaleTransition st = new ScaleTransition(Duration.millis(1400), title);
        st.setByX(3.5);
        st.setByY(3.5);
        st.setInterpolator(Interpolator.EASE_BOTH);

        ScaleTransition st2 = new ScaleTransition(Duration.millis(1700), title);
        st2.setByX(-.4);
        st2.setByY(-.4);
        st2.setInterpolator(Interpolator.EASE_BOTH);

        ScaleTransition st3 = new ScaleTransition(Duration.millis(1700), title);
        st3.setByX(.4);
        st3.setByY(.4);
        st3.setInterpolator(Interpolator.EASE_BOTH);

        FillTransition fill = new FillTransition(Duration.millis(2000), title, Color.BLACK, Color.SKYBLUE);
        fill.setCycleCount(Animation.INDEFINITE);
        fill.setAutoReverse(true);
        fill.play();

//        SequentialTransition pt = new SequentialTransition();
//        pt.getChildren().addAll(st2, st3, tt);
//        pt.setCycleCount(Animation.INDEFINITE);


        // Buttons
        SpecialButton playButton = new SpecialButton(35, 200, Color.PAPAYAWHIP, "Play", 14);
        playButton.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new LevelOneScene());});

        SpecialButton insButton = new SpecialButton(35, 200, Color.LIGHTPINK, "Instructions", 14);
        insButton.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new InstructionsScene());});

        SpecialButton shopButton = new SpecialButton(35, 200, Color.LIGHTBLUE, "Shop", 14);
        shopButton.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new ShopScene());
        });

        SpecialButton leaderboardButton = new SpecialButton(35, 200, Color.LAVENDER, "Leaderboard", 14);
        leaderboardButton.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new LeaderboardScene());});

        SpecialButton settingsButton = new SpecialButton(35, 200, Color.THISTLE, "Settings", 14);
        settingsButton.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new SettingsScene());});

        SpecialButton creditsButton = new SpecialButton(35, 200, Color.PALEVIOLETRED, "Credits", 14);
        creditsButton.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new CreditsScene());});

        ImageView skin2 = new ImageView(new Image("images/skin2.png"));
        skin2.setFitHeight(40);
        skin2.setFitWidth(40);
        skin2.setLayoutX(1050);
        skin2.setLayoutY(720);

        TranslateTransition tt = new TranslateTransition(Duration.seconds(6), skin2);
        //tt.setFromX(200);
        tt.setToX(-1100);
        //tt.setToY(0);


        // Add all buttons to VBOX
        VBox buttons = new VBox(playButton, insButton, shopButton, leaderboardButton, settingsButton, creditsButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        TranslateTransition moveGrid = new TranslateTransition(Duration.millis(700), buttons);
        moveGrid.setFromY(800);
        moveGrid.setToX(0);
        moveGrid.setToY(0);

        SequentialTransition pt = new SequentialTransition();
        pt.getChildren().addAll(st2, tt, st3);
        pt.setCycleCount(Animation.INDEFINITE);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(st, moveGrid, pt);
        sequentialTransition.play();


        this.setTop(title);
        this.setAlignment(title, Pos.BOTTOM_CENTER);
        this.setCenter(buttons);
        this.getChildren().add(skin2);
        this.setMargin(title, new Insets(100,30,30,30));

    }
}
