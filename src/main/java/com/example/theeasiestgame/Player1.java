package com.example.theeasiestgame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player1 extends ImageView {
    private ImageView player1 = new ImageView();
    private static Image playerImage = new Image("images/skin0.png");
    public Player1() {
        player1.setImage(playerImage);
        player1.setFitHeight(40);
        player1.setFitWidth(40);
    }

    public void changeImage(Image image){
        player1.setImage(image);
        playerImage = image;
    }

    public ImageView getPlayer() {
        return this.player1;
    }
}