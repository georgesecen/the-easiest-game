package com.example.theeasiestgame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RedCircleEnemy extends ImageView {
    private final ImageView redCircleEnemy;
    public RedCircleEnemy(double coordinateX, double coordinateY) {
        redCircleEnemy = new ImageView(new Image("images/enemy.png"));
        redCircleEnemy.setFitHeight(30);
        redCircleEnemy.setFitWidth(30);
        redCircleEnemy.setTranslateX(coordinateX);
        redCircleEnemy.setTranslateY(coordinateY);
    }
    public ImageView getRedCircleEnemy() {
        return redCircleEnemy;
    }

}
