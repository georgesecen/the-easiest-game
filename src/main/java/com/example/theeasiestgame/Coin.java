package com.example.theeasiestgame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Coin extends Circle {
    private Circle coin;
    private int coinCount;

    private double coordinateX;
    private double coordinateY;
    public Coin(double coordinateX, double coordinateY) {
        coin = new Circle(8, Color.YELLOW);
        coin.setStroke(Color.GOLD);
        coin.setStrokeWidth(3);
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        coin.setTranslateX(coordinateX);
        coin.setTranslateY(coordinateY);
    }
    public Circle getCoin() {
        return this.coin;
    }
    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }
    public int getCoinCount() {
        return this.coinCount;
    }

    public void removeCoin(){
        this.coin.setTranslateX(1000);
        this.coin.setTranslateY(1000);
    }
    public void replaceCoin() {
        this.coin.setTranslateX(coordinateX);
        this.coin.setTranslateY(coordinateY);
    }
}
