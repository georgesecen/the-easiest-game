package com.example.theeasiestgame.extras;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class LeaderboardItemContainer extends BorderPane {
    StackPane placementTextPane = new StackPane();
    Text placementText = new Text();

    StackPane timeTextPane = new StackPane();
    Text timeText = new Text();

    private Font font = new Font("Trebuchet MS", 40);

    private Font font2 = new Font("Trebuchet MS", 30);

    private Color backgroundColor = null;

    private Color borderColor = null;
    public LeaderboardItemContainer(double height, double width, Color backgoundColor, Color borderColor, double radius, String text, Color textColor, int minutes, int seconds){
        setContainerDimensions(height, width);
        setBackground(backgoundColor, radius);
        setBackgroundColor(backgoundColor);
        setBorderColor(borderColor);
        setBorder(borderColor, radius);

        setPriceText(text);
        setTextFont();
        setTextColor(textColor);

        // Moving the text to left center
        this.placementTextPane.getChildren().add(this.placementText);
        this.placementText.setTranslateX(10);


        this.timeText.setText(String.valueOf(minutes) + " Minutes " + String.valueOf(seconds) + " Seconds");

        this.timeTextPane.getChildren().add(this.timeText);
        this.timeTextPane.setAlignment(Pos.CENTER);
        this.timeText.setTextAlignment(TextAlignment.CENTER);

        this.timeText.setFont(this.font2);
        this.timeText.setFill(textColor);
        this.setLeft(this.placementTextPane);
        this.setCenter(this.timeTextPane);
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setContainerDimensions(double height, double width){
        this.setMinHeight(height);
        this.setMinWidth(width);
        this.setMaxHeight(height);
        this.setMaxWidth(width);
    }

    public void setBackground(Color color, double radius){
        this.setBackground(new Background(new BackgroundFill(color, new CornerRadii(radius), new Insets(1,1,1,1))));
    }
    public void setBorder(Color color, double radius){
        this.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, new CornerRadii(radius), BorderWidths.DEFAULT)));
    }

    public void setPriceText(String text){
        this.placementText.setText(text);
    }

    public void setTextFont(){
        this.placementText.setFont(this.font);
    }

    public void setTextColor(Color color){
        this.placementText.setFill(color);
    }


}
