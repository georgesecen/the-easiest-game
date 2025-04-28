package com.example.theeasiestgame;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;

public class PlayerMovement {
    private final BooleanProperty wPressed = new SimpleBooleanProperty();
    private final BooleanProperty aPressed = new SimpleBooleanProperty();
    private final BooleanProperty sPressed = new SimpleBooleanProperty();
    private final BooleanProperty dPressed = new SimpleBooleanProperty();
    private final BooleanBinding keyPressed = wPressed.or(aPressed).or(sPressed).or(dPressed);
    private final Player1 player1 = new Player1();
    private final int movementVariable = 3;

    public BooleanProperty iswPressed() {
        return wPressed;
    }
    public BooleanProperty isaPressed() {
        return aPressed;
    }
    public BooleanProperty issPressed() {
        return sPressed;
    }
    public BooleanProperty isdPressed() {
        return dPressed;
    }
    public BooleanBinding getKeyPressed() {
        return keyPressed;
    }
    public int getMovementVariable() {
        return movementVariable;
    }
    public BooleanProperty wPressedProperty() {
        return wPressed;
    }
    public BooleanProperty aPressedProperty() {
        return aPressed;
    }
    public BooleanProperty sPressedProperty() {
        return sPressed;
    }
    public BooleanProperty dPressedProperty() {
        return dPressed;
    }

    public void keyPressHandler(Scene scene) {
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {
                wPressed.set(true);
                System.out.println(player1.getPlayer().getTranslateX());
                System.out.println(player1.getPlayer().getTranslateY());
            }
            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                aPressed.set(true);
            }
            if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {
                sPressed.set(true);
            }
            if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                dPressed.set(true);
            }
        });
    }
    public void keyReleaseHandler(Scene scene) {
        scene.setOnKeyReleased(e ->{
            if(e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {
                wPressed.set(false);
            }
            if(e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                aPressed.set(false);
            }
            if(e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {
                sPressed.set(false);
            }
            if(e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                dPressed.set(false);
            }
        });
    }
}