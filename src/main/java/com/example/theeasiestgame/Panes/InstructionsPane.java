package com.example.theeasiestgame.Panes;

import com.example.theeasiestgame.Navigation;
import com.example.theeasiestgame.Scenes.IntroScene;
import com.example.theeasiestgame.extras.SoundFxMusicPlayer;
import com.example.theeasiestgame.extras.SpecialButton;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class InstructionsPane extends BorderPane {
    public InstructionsPane() {
        SoundFxMusicPlayer soundFxPlayer = new SoundFxMusicPlayer();

        Text title = new Text("Instructions");
        title.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        ScaleTransition st = new ScaleTransition(Duration.millis(700), title);
        st.setByX(3.2);
        st.setByY(3.2);
        st.setInterpolator(Interpolator.EASE_BOTH);

        // Grid will display each instruction
        GridPane grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(500));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.setVgap(25);


        // Images
        ImageView arrowKeys = new ImageView(new Image("images/arrow-keys.png"));
        arrowKeys.setFitHeight(150);
        arrowKeys.setFitWidth(150);
        ImageView enemy = new ImageView(new Image("images/enemy.png"));
        ImageView spike = new ImageView(new Image("images/spikeBall.png"));
        spike.setFitHeight(100);
        spike.setFitWidth(100);
        ImageView coins = new ImageView(new Image("images/coins.png"));


        grid.add(arrowKeys, 1, 0);
        grid.add(enemy, 1, 1);
        grid.add(spike, 2, 1);
        grid.add(coins, 1, 2);

        // Align each image to center
        grid.setHalignment(arrowKeys, HPos.CENTER);
        grid.setHalignment(enemy, HPos.CENTER);
        grid.setHalignment(coins, HPos.CENTER);

        // Text
        Text ins1 = new Text("Use the arrow keys to move");
        ins1.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        grid.add(ins1, 0, 0);

        Text ins2 = new Text("Avoid the enemies");
        ins2.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        grid.add(ins2, 0, 1);

        Text ins3 = new Text("Collect coins to purchase new skins");
        ins3.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        grid.add(ins3, 0, 2);

        // Animations
        TranslateTransition moveGrid = new TranslateTransition(Duration.millis(700), grid);
        moveGrid.setFromY(800);
        moveGrid.setToX(0);
        moveGrid.setToY(0);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(st, moveGrid);
        sequentialTransition.play();

        // Back button
        SpecialButton back = new SpecialButton(35, 50, Color.LIGHTPINK, "Back", 14);
        back.button.setOnAction(e -> {
            Navigation.mainStage.setScene(new IntroScene());
            soundFxPlayer.clickSound();
        });
        this.getChildren().add(back);
        back.setLayoutX(40);
        back.setLayoutY(30);

        this.setTop(title);
        this.setAlignment(title, Pos.BOTTOM_CENTER);
        this.setCenter(grid);
        grid.setAlignment(Pos.CENTER);
        this.setMargin(title, new Insets(100,30,30,30));
    }
}
