package com.example.theeasiestgame.extras;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SongContainer extends StackPane {

    private Text songText = new Text();

    private Font font = new Font("Trebuchet MS", 15);


    public SongContainer(){};

    public SongContainer(String text, double height, double width, Color backgroundColor, Color borderColor, double radius, int characterLimit){

        // Setting the container size
        setContainerSize(height, width);

        // Setting the text
        setText(text, characterLimit);

        // Styling the text
        setTextFont();

        // Styling the container
        setBackground(backgroundColor, radius);
        setBorder(borderColor, radius);


        // Adding the text to pane
        this.getChildren().add(this.songText);
    }

    public void setText(String text, int characterLimit){
        // Modify text to stay within limit
        if(text.length() > characterLimit){
            text = text.substring(0, characterLimit);
            text = text.concat("...");
        }
        this.songText.setText(text);
    }

    public void setContainerSize(double height, double width){
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

    public void setTextFont(){
        this.songText.setFont(this.font);
    }
}
