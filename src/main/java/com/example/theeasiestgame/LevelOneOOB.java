package com.example.theeasiestgame;

import com.example.theeasiestgame.Scenes.WinScene;
import com.example.theeasiestgame.Scenes.WinScene2;
import com.example.theeasiestgame.extras.CoinTracker;
import com.example.theeasiestgame.extras.TimeTracker;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;

public class LevelOneOOB {
        private final double oobTopLeftX = 124;
        private final double oobTopLeftY = -35;
        private final double oobBottomLeftX = 124;
        private final double oobBottomLeftY = 35;
        private final double oobTopRightX = 591;
        private final double oobTopRightY = -35;
        private final double oobBottomRightX = 591;
        private final double oobBottomRightY = 35;

        private CoinTracker coinTracker = new CoinTracker();

        private static int test = 0;

//        private static int test = 0;

    public void setOOB(Player1 player1) {
        //top left corner bounds
        if (player1.getPlayer().getTranslateX() < oobTopLeftX && player1.getPlayer().getTranslateY() < oobTopLeftY) {
            player1.getPlayer().setTranslateX(0);
            player1.getPlayer().setTranslateY(0);
        }
        //bottom left corner bounds
        if (player1.getPlayer().getTranslateX() < oobBottomLeftX && player1.getPlayer().getTranslateY() > oobBottomLeftY) {
            player1.getPlayer().setTranslateX(0);
            player1.getPlayer().setTranslateY(0);
        }
        //top right corner bounds
        if (player1.getPlayer().getTranslateX() > oobTopRightX && player1.getPlayer().getTranslateY() < oobTopRightY) {
            player1.getPlayer().setTranslateX(0);
            player1.getPlayer().setTranslateY(0);
        }
        //bottom right corner bounds
        if (player1.getPlayer().getTranslateX() > oobBottomRightX && player1.getPlayer().getTranslateY() > oobBottomRightY) {
            player1.getPlayer().setTranslateX(0);
            player1.getPlayer().setTranslateY(0);
        }
    }

    public void resetTest(){
        test = 0;
    }
    public void playerWin(Player1 player1, int coinCount, int totalCoins, int xCoordinate, int yCoordinate, AnimationTimer timer, TimeTracker timeTracker) {
        Scene currentScene = Navigation.mainStage.getScene();

//        if(this.test == 0){
            if (player1.getPlayer().getTranslateX() > xCoordinate && player1.getPlayer().getTranslateY() < yCoordinate && coinCount == totalCoins) {
                if(test == 0){
                    test++;
                    Navigation.mainStage.setScene(new WinScene());
                }
                else{
                    test = 0;
                    Navigation.mainStage.setScene(new WinScene2());
                }
//                Navigation.mainStage.setScene(new WinScene());
                System.out.println("you win!");
                timer.stop();
                // Bring player to start
                player1.getPlayer().setTranslateX(0);
                player1.getPlayer().setTranslateY(0);
//                this.test++;
                //Change scene logic

                // Adding coins to file
                coinTracker.addToCoinCount(totalCoins);
//
//                if(Objects.equals(currentScene, new WinScene())){
//                    System.out.println("ldishfo");
//                }

//                if(test == 0){
//                    test++;
//                }
//                else{
//                    timeTracker.endTimer();
//                    test = 0;
//                }
            }
//        }
    }
}
