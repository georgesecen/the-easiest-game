package com.example.theeasiestgame.extras;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class PreviewPlayer extends Pane {
    ImageView imageView = new ImageView();


    public PreviewPlayer(){}

    public PreviewPlayer(Image image) {

        // Setting image
        this.imageView.setImage(image);

        // Changing size
        this.imageView.setScaleX(1.2);
        this.imageView.setScaleY(1.2);

        // Adding ball to pane
        this.getChildren().add(imageView);
    }

    public void animate(double duration){
        TranslateTransition translate = new TranslateTransition(Duration.millis(duration), this.imageView);
        translate.setByX(100);

        TranslateTransition translate2 = new TranslateTransition(Duration.millis(duration), this.imageView);
        translate2.setByY(100);

        TranslateTransition translate3 = new TranslateTransition(Duration.millis(duration), this.imageView);
        translate3.setByX(-100);

        TranslateTransition translate4 = new TranslateTransition(Duration.millis(duration), this.imageView);
        translate4.setByY(-100);

        SequentialTransition sequentialAnimations = new SequentialTransition();
        sequentialAnimations.getChildren().addAll(
                translate,
                translate2,
                translate3,
                translate4
        );
        sequentialAnimations.setCycleCount(Animation.INDEFINITE);
        sequentialAnimations.play();
    }

    public void changeImage(Image image){
        this.imageView.setImage(image);
    }
}
