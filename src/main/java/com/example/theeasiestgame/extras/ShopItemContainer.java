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

public class ShopItemContainer extends BorderPane {

    ImageView image = new ImageView();
    // Stackpane will hold image and purchased symbol
//    StackPane itemArea = new StackPane();


    private int index;
    private boolean forSale = true;
    Pane purchasedOverlay = new Pane();

    StackPane pricePane = new StackPane();
    Text priceText = new Text();

    private int itemPrice;
    private Font font = new Font("Trebuchet MS", 20);

    private Color backgroundColor = null;

    private Color borderColor = null;
    public ShopItemContainer(double height, double width, Color backgoundColor, Color borderColor, double radius, int price, Color textColor, int index, Image image){
        setContainerDimensions(height, width);
        setBackground(backgoundColor, radius);
        setBackgroundColor(backgoundColor);
        setBorderColor(borderColor);
        setBorder(borderColor, radius);

        this.itemPrice = price;
        this.index = index;

//        setPriceText("\uD83D\uDCB0 " + String.valueOf(price));
        setPriceText("$" + String.valueOf(price));
        setTextFont();
        setTextColor(textColor);

        setOverlayDimensions(height - 20, width - 20);
        setPurchasedOverlayBackground(Color.GREEN, 10);
        this.purchasedOverlay.setOpacity(0.6);
        this.purchasedOverlay.setTranslateY(10);



        // Moving the text to bottom right corner
        this.pricePane.getChildren().add(this.priceText);
        this.pricePane.setAlignment(Pos.BOTTOM_RIGHT);
        this.priceText.setTranslateX(-10);
        this.priceText.setTranslateY(-5);

        this.image.setImage(image);


        this.setBottom(this.pricePane);
        this.setCenter(this.image);
//        this.itemArea.setAlignment(Pos.CENTER);
    }

    public Image getImage(){
        return this.image.getImage();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public int getItemPrice(){
        return this.itemPrice;
    }
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public int getIndex(){
        return this.index;
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

    public void setOverlayDimensions(double height, double width){
        this.purchasedOverlay.setMinHeight(height);
        this.purchasedOverlay.setMinWidth(width);
        this.purchasedOverlay.setMaxHeight(height);
        this.purchasedOverlay.setMaxWidth(width);
    }

    public void setBackground(Color color, double radius){
        this.setBackground(new Background(new BackgroundFill(color, new CornerRadii(radius), new Insets(1,1,1,1))));
    }

    public void setPurchasedOverlayBackground(Color color, double radius){
        this.purchasedOverlay.setBackground(new Background(new BackgroundFill(color, new CornerRadii(radius), new Insets(1,1,1,1))));
    }

    public void setBorder(Color color, double radius){
        this.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, new CornerRadii(radius), BorderWidths.DEFAULT)));
    }

    public void setPriceText(String text){
        this.priceText.setText(text);
    }

    public String getPriceText(){
        return this.priceText.getText();
    }

    public void setTextFont(){
        this.priceText.setFont(this.font);
    }

    public void setTextColor(Color color){
        this.priceText.setFill(color);
    }

    public void itemPurchased(){
        this.priceText.setText("✅");
        this.priceText.setFill(Color.GREEN);
        this.priceText.setFont(new Font("Trebuchet MS", 40));
        this.priceText.setTranslateX(10);
        this.priceText.setTranslateY(2);
        this.forSale = false;
    }

    public boolean isForSale(){
        return this.forSale;
    }

    public void insufficentFundsAnimation(double duration){

        TranslateTransition translateStart = new TranslateTransition(Duration.millis(duration), this);
        translateStart.setFromX(0);
        translateStart.setToX(5);

        TranslateTransition translateLeft = new TranslateTransition(Duration.millis(duration), this);
        translateLeft.setFromX(5);
        translateLeft.setToX(-5);

        TranslateTransition translateRight = new TranslateTransition(Duration.millis(duration), this);
        translateRight.setFromX(-5);
        translateRight.setToX(5);

        TranslateTransition translateLeft2 = new TranslateTransition(Duration.millis(duration), this);
        translateLeft2.setFromX(5);
        translateLeft2.setToX(-5);

        TranslateTransition translateRight2 = new TranslateTransition(Duration.millis(duration), this);
        translateRight2.setFromX(-5);
        translateRight2.setToX(5);

        TranslateTransition translateEnd = new TranslateTransition(Duration.millis(duration), this);
        translateEnd.setFromX(5);
        translateEnd.setToX(0);


        SequentialTransition sequentialAnimations = new SequentialTransition();
        sequentialAnimations.getChildren().addAll(
                translateStart,
                translateLeft,
                translateRight,
                translateLeft2,
                translateRight2,
                translateEnd

        );

        sequentialAnimations.play();

        setBackground(Color.ORANGERED, 15);
        setBorder(Color.DARKRED, 15);

        sequentialAnimations.setOnFinished(e->{
            setBackground(getBackgroundColor(), 15);
            setBorder(getBorderColor(), 15);
        });


    }

    public void sufficentFundsAnimation(double duration){

        TranslateTransition translateStart = new TranslateTransition(Duration.millis(duration), this);
        translateStart.setFromY(0);
        translateStart.setToY(-5);

        TranslateTransition translateUp = new TranslateTransition(Duration.millis(duration), this);
        translateUp.setFromY(-5);
        translateUp.setToY(5);

        TranslateTransition translateDown = new TranslateTransition(Duration.millis(duration), this);
        translateDown.setFromY(5);
        translateDown.setToY(-5);

        TranslateTransition translateEnd = new TranslateTransition(Duration.millis(duration), this);
        translateEnd.setFromY(-5);
        translateEnd.setToY(0);


        SequentialTransition sequentialAnimations = new SequentialTransition();
        sequentialAnimations.getChildren().addAll(
                translateStart,
                translateUp,
                translateDown,
                translateEnd

        );

        sequentialAnimations.play();

        setBackground(Color.GREEN, 15);
        setBorder(Color.DARKGREEN, 15);

        sequentialAnimations.setOnFinished(e->{
            setBackground(getBackgroundColor(), 15);
            setBorder(getBorderColor(), 15);
        });


    }
}
