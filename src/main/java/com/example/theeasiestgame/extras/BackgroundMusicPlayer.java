package com.example.theeasiestgame.extras;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BackgroundMusicPlayer {
    private static MediaPlayer player = null;

    private static boolean on = true;

    public BackgroundMusicPlayer(){};

    public void stopPlaying(){
        if(isPlaying()){
            this.player.stop();
            turnOffPlayer();
        }
        turnOffPlayer();
    }
    public void playMusicFromFile(File file){
//        System.out.println(on);
        if(on){
            if(isPlaying()){

                this.player.stop();
                Media media = new Media(file.toURI().toString());
                this.player = new MediaPlayer(media);
                this.player.play();
            }
            else{
                Media media = new Media(file.toURI().toString());
                this.player = new MediaPlayer(media);
                this.player.play();
            }
        }
    }

    public boolean isPlaying(){
        if(this.player != null){
            switch (player.getStatus()){
                case PLAYING -> {
                    return true;
                }
            }
        }

        return false;
    }

    public MediaPlayer getPlayer(){return this.player;}

    public void turnOffPlayer(){
        on = false;
    }

    public void turnOnPlayer(){
        on = true;
    }

    public boolean getOnStatus(){
        return on;
    }

}
