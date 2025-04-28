package com.example.theeasiestgame.extras;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SoundFxMusicPlayer {
    private static MediaPlayer player = null;

    private static boolean on = true;

    private File clickSoundFile = new File("Media/soundFx/click.mp3");
    private File cashSoundFile = new File("Media/soundFx/cash.mp3");
    private File errorSoundFile = new File("Media/soundFx/error.mp3");

    private File tapSoundFile = new File("Media/soundFx/tap.mp3");

    private File finishFile = new File("Media/soundFx/twinkle.mp3");

    private File coinFile = new File("Media/soundFx/coin.mp3");

    private File hitFile = new File("Media/soundFx/hit.mp3");

    public SoundFxMusicPlayer(){};

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

//                this.player.stop();
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

    public void clickSound(){
        playMusicFromFile(this.clickSoundFile);
    }

    public void errorSound(){
        playMusicFromFile(this.errorSoundFile);
    }
    public void cashSound(){
        playMusicFromFile(this.cashSoundFile);
    }

    public void levelFinish(){playMusicFromFile(this.finishFile);}

    public void tapSound(){
        playMusicFromFile(this.tapSoundFile);
    }

    public void coinSound(){playMusicFromFile(this.coinFile);}

    public void hitSound(){playMusicFromFile(this.hitFile);}

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
