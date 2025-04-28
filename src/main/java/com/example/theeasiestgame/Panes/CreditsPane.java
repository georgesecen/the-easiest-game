package com.example.theeasiestgame.Panes;

import com.example.theeasiestgame.Navigation;
import com.example.theeasiestgame.Scenes.IntroScene;
import com.example.theeasiestgame.extras.SoundFxMusicPlayer;
import com.example.theeasiestgame.extras.SpecialButton;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class CreditsPane extends BorderPane {
    public CreditsPane(){
        SoundFxMusicPlayer soundFxPlayer = new SoundFxMusicPlayer();

        Text creators = new Text("Creators:");
        Text name = new Text("Wania");
        //Text desc = new Text("Introduction scene\nInstructions scene\n  Credits scene");
        Text name2 = new Text("George");
        //Text desc2 = new Text("  Shop scene\nSettings scene\n Button class");
        Text name3 = new Text("Cameron");
        //Text desc3 = new Text("Level creation");
        Text imgCreds = new Text("Images by icons8 at https://icons8.com/");

        creators.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 40));
        name.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        name2.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        name3.setFont(Font.font("Courier New", FontWeight.BOLD, 30));

        //desc.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        //desc2.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        //desc3.setFont(Font.font("Courier New", FontWeight.BOLD, 20));

        imgCreds.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 20));

        VBox vbox = new VBox(creators, name, name2, name3, imgCreds);
        vbox.setSpacing(25);

        //Transition
        TranslateTransition move = new TranslateTransition(Duration.seconds(15), vbox);
        move.setFromY(650);
        move.setToY(-650);
        move.play();

        this.setCenter(vbox);
        vbox.setAlignment(Pos.CENTER);

        // Back button
        SpecialButton back = new SpecialButton(35, 50, Color.LIGHTPINK, "Back", 14);
        back.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new IntroScene());
        });
        this.getChildren().add(back);
        back.setLayoutX(40);
        back.setLayoutY(30);
    }

}
