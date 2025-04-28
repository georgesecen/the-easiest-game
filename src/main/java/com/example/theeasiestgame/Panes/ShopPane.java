package com.example.theeasiestgame.Panes;

import com.example.theeasiestgame.Navigation;
import com.example.theeasiestgame.Player1;
import com.example.theeasiestgame.Scenes.IntroScene;
import com.example.theeasiestgame.extras.*;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

import java.util.ArrayList;

public class ShopPane extends BorderPane {
    public ShopPane(){
        SoundFxMusicPlayer soundFxPlayer = new SoundFxMusicPlayer();
        Player1 player = new Player1();

        // Back button and shop title
        SpecialButton backButton = new SpecialButton(35, 50, Color.LIGHTPINK, "Back", 14);
        backButton.button.setOnAction(e -> {
            soundFxPlayer.clickSound();
            Navigation.mainStage.setScene(new IntroScene());
        });

        Text title = new Text("Shop");
        title.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 50));
        title.setTranslateY(10);

        // Creating the coin tracker object to keep track of user balance
        CoinTracker coinTracker = new CoinTracker();

        Text currentBalanceText = new Text("$" + coinTracker.getCoinCount());
        // Styling the balance text
        currentBalanceText.setFill(Color.GOLD);
        currentBalanceText.setScaleX(4);
        currentBalanceText.setScaleY(4);

        HBox topElements = new HBox();
        topElements.setAlignment(Pos.CENTER);
        topElements.setSpacing(100);
        topElements.getChildren().addAll(backButton, title, currentBalanceText);

        // Getting shop items sales list 0 means for sale, 1 means purchased
        ShopTracker shopTracker = new ShopTracker();
        ArrayList<Integer> shopItemsSaleList = shopTracker.getShopDataFromFile();

        // Creating vbox to put preview player and text in
        VBox previewArea = new VBox();
        Text previewText = new Text("Preview Player");
        previewText.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 30));
        PreviewPlayer previewPlayer = new PreviewPlayer(new Image("images/skin0.png"));
        previewPlayer.animate(1000);
        previewArea.getChildren().addAll(previewText, previewPlayer);

        // Creating shop items list
        ArrayList<ShopItemContainer> shopItemsList = new ArrayList<>();
        int price = 10;
        for (int i = 0; i < shopItemsSaleList.size(); i++) {
            String gg = "images/skin" + i + ".png";
//            System.out.println(gg);
            Image itemImage = new Image(gg);
            ShopItemContainer item = new ShopItemContainer(150, 150, Color.DEEPSKYBLUE, Color.TRANSPARENT, 15, price, Color.GOLD, i, itemImage);
            // Check if item is already purchased
            if(shopItemsSaleList.get(i) == 1){ // 1 is purchased, 0 is not
                item.itemPurchased();
            }

            // Adding animations to shop items
            item.setOnMouseClicked(e->{
                buyingItem(item, shopItemsSaleList, coinTracker.getCoinCount(), shopTracker, coinTracker, currentBalanceText, soundFxPlayer);

                // Changing preview player image
                previewPlayer.changeImage(item.getImage());

                // Set the actual player image to item
                if(!item.isForSale()){
                    player.changeImage(item.getImage());
                }

            });

//            player.changeImage(new Image("images/skin2.png"));

            shopItemsList.add(item);
            price += 10;
        }

        // Creating 1st vbox and adding shop items
        VBox shopItems1 = new VBox();
        for (int i = 0; i < 3; i++) {
            shopItems1.getChildren().add(shopItemsList.get(i));
        }

        // Creating second vbox and adding shop items
        VBox shopItems2 = new VBox();
        for (int i = 3; i < 6; i++) {
            shopItems2.getChildren().add(shopItemsList.get(i));
        }

        // Creating hbox to both columns of shop items
        HBox allShopItems = new HBox();
        allShopItems.getChildren().addAll(shopItems1, shopItems2);

        // Creating hbox to put both the preview items and shop items in
        HBox centerElements = new HBox();
        centerElements.getChildren().addAll(previewArea, allShopItems);


//        previewPlayerAnimation(previewText, 3000);


        // Adding elements to borderpane
        this.setCenter(centerElements);
        this.setTop(topElements);

        // Positioning
        shopItems1.setSpacing(15);
        shopItems2.setSpacing(15);

        allShopItems.setSpacing(20);
        allShopItems.setTranslateY(90);
        allShopItems.setTranslateX(80);

        previewArea.setTranslateY(200);
        previewArea.setTranslateX(-100);
        previewArea.setSpacing(20);

        previewText.setTranslateY(-30);

        currentBalanceText.setTranslateX(220);
        currentBalanceText.setTranslateY(20);

        backButton.setTranslateX(-300);
        backButton.setTranslateY(20);


        previewPlayer.setTranslateX(45);

        centerElements.setAlignment(Pos.CENTER);

    }

    public void buyingItem(ShopItemContainer shopItem,ArrayList<Integer> shopItemsSaleList ,int balance, ShopTracker shopTracker, CoinTracker coinTracker, Text balanceText, SoundFxMusicPlayer sfx){ // Runs animation on item based on if user can afford it
        // If item is for sale and balance is enough
        if(shopItem.isForSale()){
            if(balance >= shopItem.getItemPrice()){
                // Change item status to purchased
                shopItem.itemPurchased();
                // Change shop item index from 0 (for sale) to 1 (purchased)
                shopItemsSaleList.set(shopItem.getIndex(), 1);
                // Updating the shops file
                shopTracker.updateShopsFileFromList(shopItemsSaleList);
                // Running animation
                shopItem.sufficentFundsAnimation(100);

                // Updating the coin file by subtracting from balance
                coinTracker.addToCoinCount(-shopItem.getItemPrice());

                // Updating the coin balance at top right of screen
                updateCurrentBalanceText(balanceText, coinTracker.getCoinCount());

                // Run cash sound
                sfx.cashSound();

            }
            else{
                // Run animation
                shopItem.insufficentFundsAnimation(100);

                // Run error sound
                sfx.errorSound();
            }
        }
    }

    public void updateCurrentBalanceText(Text text, int balance){
        text.setText("$" + balance);
    }

}
