package com.example.theeasiestgame.extras;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SpecialButton extends StackPane {
    private Pane boxShadow = new Pane();
    public Button button = new Button();

    private SoundFxMusicPlayer soundFxPlayer = new SoundFxMusicPlayer();

    public SpecialButton(){};

    public SpecialButton(double buttonHeight, double buttonWidth, Color buttonColor, String text, double fontSize) {

        // Setting the button text and font
        setButtonText(text);
        setButtonFont(fontSize);

        // Setting the button and box shadow height and width
        setButtonSize(buttonHeight, buttonWidth);
        setBoxShadowSize(buttonHeight - 1, buttonWidth - 1);

        // Setting the box shadow position
        setBoxShadowPosition(5, 5);

        // Changing the box shadow and button backgrounds
        setBoxShadowBackground(Color.BLACK);
        setButtonBackground(buttonColor);

        // Adding boxshadow and button to the stackpane
        this.getChildren().addAll(boxShadow, button);

        // Event handlers
        button.setOnMouseEntered(e->{
            setButtonPosition(5, 5);
        });
        button.setOnMouseExited(e->{
            setButtonPosition(0, 0);
        });
//        button.setOnAction(e->{
//            soundFxPlayer.clickSound();
//        });
    }

    public String getText(){
        return this.button.getText();
    }
    public void setButtonSize(double height, double width){
        this.button.setMinHeight(height);
        this.button.setMinWidth(width);
        this.button.setMaxHeight(height);
        this.button.setMaxWidth(width);
    }

    public void setBoxShadowSize(double height, double width){
        this.boxShadow.setMinHeight(height);
        this.boxShadow.setMinWidth(width);
        this.boxShadow.setMaxHeight(height);
        this.boxShadow.setMaxWidth(width);
    }

    public void setBoxShadowPosition(double x, double y){
        this.boxShadow.setTranslateX(x);
        this.boxShadow.setTranslateY(y);
    }

    public void setButtonPosition(double x, double y){
        this.button.setTranslateX(x);
        this.button.setTranslateY(y);
    }

    public void setButtonBackground(Color color){
        this.button.setBackground(new Background(new BackgroundFill(color, new CornerRadii(20), new Insets(1,1,1,1))));
    }

    public void setBoxShadowBackground(Color color){
        this.boxShadow.setBackground(new Background(new BackgroundFill(color, new CornerRadii(20), new Insets(1,1,1,1))));
    }

    public void setButtonText(String text){
        this.button.setText(text);
    }

    public void setButtonFont(double fontSize){
        Font textFont = new Font("Trebuchet MS", fontSize);
        this.button.setFont(textFont);
    }

}

