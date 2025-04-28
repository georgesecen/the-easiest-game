package com.example.theeasiestgame.Panes;

import com.example.theeasiestgame.*;
import com.example.theeasiestgame.extras.TimeTracker;
import com.example.theeasiestgame.overlays.CoinTotalText;
import com.example.theeasiestgame.overlays.DeathCountText;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
public class LevelOnePane extends GridPane {
    private final Player1 player1 = new Player1();
    private final PlayerBounds playerBounds = new PlayerBounds(4,0,715,132,-131);
    private final LevelOneOOB levelOneOOB = new LevelOneOOB();
    private int coinTotal;
    private final MapOne mapOne = new MapOne();
    private final SpikeBall spikeBall = new SpikeBall();
    private final Leve1Animations animations = new Leve1Animations();
    private final PlayerMovement playerMovement = new PlayerMovement();
    private final CollisionMethods collision = new CollisionMethods();
    private final CoinTotalText coinTotalText = new CoinTotalText();
    private final DeathCountText deathCountText = new DeathCountText();
    private TimeTracker timeTracker = new TimeTracker();
    private final int finishBoundX = 650;
    private final int finishBoundY = 35;
    public LevelOnePane() {
            // Starting time
            timeTracker.startTimer();
            //Change Title
            Navigation.mainStage.setTitle("Lavel 1");
            this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
            //Creating map with shapes
            Rectangle startRect = new Rectangle(126, 97, Color.GREEN);
            HBox startBox = new HBox(startRect);
            startBox.setAlignment(Pos.CENTER_LEFT);
            startBox.setTranslateX(4);
            Rectangle endRect = new Rectangle(126, 97, Color.GREEN);
            HBox endBox = new HBox(endRect);
            endBox.setAlignment(Pos.CENTER_RIGHT);
            endBox.setTranslateX(-4);
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
                    levelOneOOB.setOOB(player1);
                }
            };
            // Determine when to run timer
            playerMovement.getKeyPressed().addListener(((observableValue, aBoolean, t1) -> {
                if (!aBoolean) {
                    timer.start();
                } else {
                    timer.stop();
                }
            }));
            // Create/set enemy shapes
        ArrayList<RedCircleEnemy> enemyArrayList = new ArrayList<>();
        enemyArrayList.add(new RedCircleEnemy(175,125));
        enemyArrayList.add(new RedCircleEnemy(275,125));
        enemyArrayList.add(new RedCircleEnemy(175,-125));
        enemyArrayList.add(new RedCircleEnemy(275,-125));
            //Coins
        ArrayList<Coin> coinArrayList = new ArrayList<>();
        coinArrayList.add(new Coin(355,20));
        coinArrayList.add(new Coin(355,0));
        coinArrayList.add(new Coin(375,20));
        coinArrayList.add(new Coin(375,0));
        coinArrayList.add(new Coin(395,20));
        coinArrayList.add(new Coin(395,0));
            //Collision Timer
            AnimationTimer collisionTimer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    for (RedCircleEnemy x : enemyArrayList) {
                        collision.enemyCollision(player1.getPlayer(), enemyArrayList, coinArrayList, 4,4);
                    }
                    collision.spikeCollision(player1.getPlayer(), spikeBall, coinArrayList,4,4);
                    for (Coin coin : coinArrayList) {
                        collision.coinCollision(player1.getPlayer(), coin);
                    }
                    //Increment Coin Counter
                    coinTotal = coinArrayList.get(0).getCoinCount() + coinArrayList.get(1).getCoinCount() +
                            coinArrayList.get(2).getCoinCount() + coinArrayList.get(3).getCoinCount() +
                            coinArrayList.get(4).getCoinCount() + coinArrayList.get(5).getCoinCount();
                    coinTotalText.getCoinCountText().setText("Coins: " + coinTotal);
                    deathCountText.getDeathCountText().setText("Deaths: " + collision.getDeathCount());
                }
            };
            collisionTimer.start();
            if(player1.getPlayer().getTranslateX() > 650 && player1.getPlayer().getTranslateY() < 35 && coinTotal == 6) {
                collisionTimer.stop();
            }
            //Call circle animation functions
            animations.slideTranslate(enemyArrayList.get(0).getRedCircleEnemy(), -250, 'y');
            animations.slideTranslate(enemyArrayList.get(1).getRedCircleEnemy(), -250,'y');
            animations.slideTranslate(enemyArrayList.get(2).getRedCircleEnemy(),250,'y');
            animations.slideTranslate(enemyArrayList.get(3).getRedCircleEnemy(),250,'y');
            animations.CircularPathAnimation(spikeBall.getSpikeBall());
            //Add to Scene
            this.setAlignment(Pos.CENTER);
            this.add(mapOne.getMapOne(), 1, 1);
            this.add(startBox, 1, 1);
            this.add(endBox, 1, 1);
            this.add(spikeBall.getSpikeBall(), 1, 1);
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
            //Define movement
        this.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {
                playerMovement.wPressedProperty().set(true);
                levelOneOOB.playerWin(player1, coinTotal, 12, finishBoundX,finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                playerMovement.aPressedProperty().set(true);
                levelOneOOB.playerWin(player1, coinTotal, 12, finishBoundX,finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {
                playerMovement.sPressedProperty().set(true);
                levelOneOOB.playerWin(player1, coinTotal, 12, finishBoundX,finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                playerMovement.dPressedProperty().set(true);
                levelOneOOB.playerWin(player1, coinTotal, 12, finishBoundX,finishBoundY, collisionTimer, timeTracker);
            }
        });
        this.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {
                playerMovement.wPressedProperty().set(false);
                levelOneOOB.playerWin(player1, coinTotal, 12, finishBoundX,finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                playerMovement.aPressedProperty().set(false);
                levelOneOOB.playerWin(player1, coinTotal, 12, finishBoundX,finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {
                playerMovement.sPressedProperty().set(false);
                levelOneOOB.playerWin(player1, coinTotal, 12, finishBoundX,finishBoundY, collisionTimer, timeTracker);
            }
            if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                playerMovement.dPressedProperty().set(false);
                levelOneOOB.playerWin(player1, coinTotal, 12, finishBoundX,finishBoundY, collisionTimer, timeTracker);
            }
        });
    }
}