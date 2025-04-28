package com.example.theeasiestgame;

import com.example.theeasiestgame.extras.SoundFxMusicPlayer;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;

public class CollisionMethods {
    private static int deathCount;

    private SoundFxMusicPlayer sfx = new SoundFxMusicPlayer();

    public int getDeathCount() {
        return deathCount;
    }
    public void enemyCollision(ImageView player, ArrayList<RedCircleEnemy> enemyArr, ArrayList<Coin> circleArr, int xCoordinate, int yCoordinate) {
        for (RedCircleEnemy circleEnemy : enemyArr) {
            if (player.getBoundsInParent().intersects(circleEnemy.getRedCircleEnemy().getBoundsInParent())) {
                player.setTranslateX(xCoordinate);
                player.setTranslateY(yCoordinate);
                //Increment Death Count
                deathCount++;

                // Make noise
                sfx.tapSound();

                for (Coin coin : circleArr) {
                    coin.getCoin().setVisible(true);
                    coin.setCoinCount(0);
                    coin.replaceCoin();
                }
            }
        }
    }
    //Spike ball enemy collision method
    public void spikeCollision(ImageView player, SpikeBall enemy, ArrayList<Coin> circleArr, int xCoordinate, int yCoordinate) {
        if(player.getBoundsInParent().intersects(enemy.getSpikeBall().getBoundsInParent())) {
            player.setTranslateY(yCoordinate);
            player.setTranslateX(xCoordinate);
            deathCount++;

            // Make noise
            sfx.hitSound();


            for(Coin coin : circleArr) {
                coin.getCoin().setVisible(true);
                coin.setCoinCount(0);
                coin.replaceCoin();
            }
        }
    }
    //collect coin method
    public void coinCollision(ImageView player, Coin coin) {
        if(player.getBoundsInParent().intersects(coin.getCoin().getBoundsInParent())) {
            coin.removeCoin();
            coin.setCoinCount(2);

            // Make noise
            sfx.coinSound();
        } else {
            coin.getCoin().setVisible(true);
        }
    }
}
