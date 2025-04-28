package com.example.theeasiestgame.Panes;

import com.example.theeasiestgame.*;
import com.example.theeasiestgame.extras.TimeTracker;
import com.example.theeasiestgame.overlays.CoinTotalText;
import com.example.theeasiestgame.overlays.DeathCountText;
import com.example.theeasiestgame.Scenes.LevelTwoScene;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class LevelTwoPane extends GridPane {
    private final Player1 player1 = new Player1();
    private final PlayerBounds playerBounds = new PlayerBounds(50,0,715,132,-131);
    private int coinTotal;
    private final SpikeBall spikeBall = new SpikeBall();
    private final Leve1Animations animations = new Leve1Animations();
    private final PlayerMovement playerMovement = new PlayerMovement();
    private final CollisionMethods collision = new CollisionMethods();
    private final CoinTotalText coinTotalText = new CoinTotalText();
    private final DeathCountText deathCountText = new DeathCountText();
    private final LevelOneOOB levelOneOOB = new LevelOneOOB();
    private final Rectangle startingSquare = new Rectangle(50,50, Color.GREEN);
    private final Rectangle finishingSquare = new Rectangle(50,50,Color.GREEN);
    private final int playerCoordinateX = 50;
    private final int playerCoordinateY = 80;

    private final int finishBoundX = 650;
    private final int finishBoundY = -60;
    private TimeTracker timeTracker = new TimeTracker();
    //Constructor
    public LevelTwoPane() {
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        //Change Title
        Navigation.mainStage.setTitle("Level 2");
        //Creating map with shapes
        Rectangle map = new Rectangle(750,300);
        map.setFill(Color.WHITE);
        map.setStrokeWidth(4);
        map.setStroke(Color.BLACK);
        startingSquare.setTranslateX(45);
        startingSquare.setTranslateY(80);
        finishingSquare.setTranslateX(656);
        finishingSquare.setTranslateY(-80);
        //Animation Timer
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (playerMovement.iswPressed().get()) {
                    player1.getPlayer().setTranslateY(player1.getPlayer().getTranslateY() - playerMovement.getMovementVariable());
                }
                if (playerMovement.isaPressed().get()) {
                    player1.getPlayer().setTranslateX(player1.getPlayer().getTranslateX() - playerMovement.getMovementVariable());
                }
                if (playerMovement.issPressed().get()) {
                    player1.getPlayer().setTranslateY(player1.getPlayer().getTranslateY() + playerMovement.getMovementVariable());
                }
                if (playerMovement.isdPressed().get()) {
                    player1.getPlayer().setTranslateX(player1.getPlayer().getTranslateX() + playerMovement.getMovementVariable());
                }
                playerBounds.setBounds(player1);
            }
        };
        //Player start position
        player1.getPlayer().setTranslateX(playerCoordinateX);
        player1.getPlayer().setTranslateY(playerCoordinateY);
        // Determine when to run timer
        playerMovement.getKeyPressed().addListener(((observableValue, aBoolean, t1) -> {
            if (!aBoolean) {
                timer.start();
            } else {
                timer.stop();
            }
        }));
        // Create/set enemy shapes array
        ArrayList<RedCircleEnemy> enemyArrayList = new ArrayList<>();
        int xCoordinate = 11;
        int yCoordinate = 125;
        for (int i = 0; i < 38; i++) {
            //Top Row
            if(i < 15) {
                enemyArrayList.add(new RedCircleEnemy(xCoordinate,-125));
                xCoordinate += 50;
            //Bottom Row
            } else if(i < 30) {
                xCoordinate -= 50;
                enemyArrayList.add(new RedCircleEnemy(xCoordinate,125));
            //Left Row
            } else if(i < 34) {
                yCoordinate -= 50;
                enemyArrayList.add(new RedCircleEnemy(11, yCoordinate));
            //Right Row
            } else if(i < 38) {
                enemyArrayList.add(new RedCircleEnemy(711, yCoordinate));
                yCoordinate += 50;
            }
        }
        //Inner enemies - spawn divider
        enemyArrayList.add(new RedCircleEnemy(60,-25));
        enemyArrayList.add(new RedCircleEnemy(110,-25));
        enemyArrayList.add(new RedCircleEnemy(160,-25));
        enemyArrayList.add(new RedCircleEnemy(60,25));
        enemyArrayList.add(new RedCircleEnemy(110,25));
        enemyArrayList.add(new RedCircleEnemy(160,25));
        //Inner enemies - mid divider
        enemyArrayList.add(new RedCircleEnemy(311,-75));
        enemyArrayList.add(new RedCircleEnemy(311,-25));
        enemyArrayList.add(new RedCircleEnemy(311,75));
        //Spikeball enemies
        spikeBall.getSpikeBall().setTranslateX(225);
        spikeBall.getSpikeBall().setTranslateY(-75);
        animations.slideTranslate(spikeBall.getSpikeBall(),155,'y');
        SpikeBall spikeBall1 = new SpikeBall();
        spikeBall1.getSpikeBall().setTranslateX(405);
        spikeBall1.getSpikeBall().setTranslateY(-75);
        animations.slideTranslate(spikeBall1.getSpikeBall(),190,'x');
        SpikeBall spikeBall2 = new SpikeBall();
        spikeBall2.getSpikeBall().setTranslateX(655);
        spikeBall2.getSpikeBall().setTranslateY(0);
        animations.slideTranslate(spikeBall2.getSpikeBall(), -300,'x');
        SpikeBall spikeBall3 = new SpikeBall();
        spikeBall3.getSpikeBall().setTranslateX(350);
        spikeBall3.getSpikeBall().setTranslateY(75);
        animations.slideTranslate(spikeBall3.getSpikeBall(), 300,'x');
        //Coins
        ArrayList<Coin> coinArrayList = new ArrayList<>();
        coinArrayList.add(new Coin(55,-85));
        coinArrayList.add(new Coin(75,-85));
        coinArrayList.add(new Coin(55,-65));
        coinArrayList.add(new Coin(75,-65));
        coinArrayList.add(new Coin(355,-85));
        coinArrayList.add(new Coin(375,-85));
        coinArrayList.add(new Coin(355,-65));
        coinArrayList.add(new Coin(375,-65));
        //Collision Timer
        AnimationTimer collisionTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (RedCircleEnemy x : enemyArrayList) {
                    collision.enemyCollision(player1.getPlayer(), enemyArrayList, coinArrayList,playerCoordinateX,playerCoordinateY);
                }
                collision.spikeCollision(player1.getPlayer(), spikeBall, coinArrayList,playerCoordinateX,playerCoordinateY);
                collision.spikeCollision(player1.getPlayer(), spikeBall1, coinArrayList,playerCoordinateX,playerCoordinateY);
                collision.spikeCollision(player1.getPlayer(), spikeBall2, coinArrayList,playerCoordinateX,playerCoordinateY);
                collision.spikeCollision(player1.getPlayer(), spikeBall3, coinArrayList,playerCoordinateX,playerCoordinateY);
                for (Coin coin : coinArrayList) {
                    collision.coinCollision(player1.getPlayer(), coin);
                }
                //Increment Coin Counter
                coinTotal = coinArrayList.get(0).getCoinCount() + coinArrayList.get(1).getCoinCount() +
                        coinArrayList.get(2).getCoinCount() + coinArrayList.get(3).getCoinCount()
                        + coinArrayList.get(4).getCoinCount() + coinArrayList.get(5).getCoinCount()
                        + coinArrayList.get(6).getCoinCount() + coinArrayList.get(7).getCoinCount();
                coinTotalText.getCoinCountText().setText("Coins: " + coinTotal);
                deathCountText.getDeathCountText().setText("Deaths: " + collision.getDeathCount());
            }
        };
        collisionTimer.start();
        //Add to Scene
        this.setAlignment(Pos.CENTER);
        this.add(map, 1, 1);
        this.add(startingSquare,1,1);
        this.add(finishingSquare,1,1);
        this.add(spikeBall.getSpikeBall(), 1, 1);
        this.add(spikeBall1.getSpikeBall(), 1, 1);
        this.add(spikeBall2.getSpikeBall(),1,1);
        this.add(spikeBall3.getSpikeBall(),1,1);
        this.add(coinTotalText.getCoinCountText(), 1, 2);
        this.add(deathCountText.getDeathCountText(), 1, 3);
        //Add redCircleEnemies to scene
        for (RedCircleEnemy redCircleEnemy : enemyArrayList) {
            this.add(redCircleEnemy.getRedCircleEnemy(), 1, 1);
        }
        for (Coin coin : coinArrayList) {
            this.add(coin.getCoin(), 1, 1);
        }
        this.add(player1.getPlayer(), 1, 1);
        this.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {
                playerMovement.wPressedProperty().set(true);
                levelOneOOB.playerWin(player1, coinTotal, 16, finishBoundX, finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                playerMovement.aPressedProperty().set(true);
                levelOneOOB.playerWin(player1, coinTotal, 16, finishBoundX, finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {
                playerMovement.sPressedProperty().set(true);
                levelOneOOB.playerWin(player1, coinTotal, 16, finishBoundX, finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                playerMovement.dPressedProperty().set(true);
                levelOneOOB.playerWin(player1, coinTotal, 16, finishBoundX, finishBoundY, collisionTimer, timeTracker);
            }
        });
        this.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {
                playerMovement.wPressedProperty().set(false);
                levelOneOOB.playerWin(player1, coinTotal, 16, finishBoundX, finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                playerMovement.aPressedProperty().set(false);
                levelOneOOB.playerWin(player1, coinTotal, 16, finishBoundX, finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {
                playerMovement.sPressedProperty().set(false);
                levelOneOOB.playerWin(player1, coinTotal, 16, finishBoundX, finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                playerMovement.dPressedProperty().set(false);
                levelOneOOB.playerWin(player1, coinTotal, 16, finishBoundX, finishBoundY, collisionTimer, timeTracker);
            }
            });
    }
}