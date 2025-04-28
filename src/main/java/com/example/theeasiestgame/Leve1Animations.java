package com.example.theeasiestgame;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
public class Leve1Animations {
    public Leve1Animations() {}
    public void slideTranslate(ImageView shape, int Coordinate, char axis) {
        TranslateTransition bottomCircleOne = new TranslateTransition();
        bottomCircleOne.setDuration(Duration.millis(1300));
        bottomCircleOne.setNode(shape);
        if(axis == 'y') {
            bottomCircleOne.setByY(Coordinate);
        } else {
            bottomCircleOne.setByX(Coordinate);
        }
        bottomCircleOne.setCycleCount(Animation.INDEFINITE);
        bottomCircleOne.setAutoReverse(true);
        bottomCircleOne.play();
    }
    public void CircularPathAnimation(ImageView enemy) {
        Circle circle = new Circle(80);
        circle.setTranslateX(520);
        circle.setTranslateY(20);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(enemy);
        pathTransition.setDuration(Duration.seconds(2));
        pathTransition.setPath(circle);
        pathTransition.setAutoReverse(true);
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.play();
    }
}