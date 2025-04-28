package com.example.theeasiestgame;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpikeBall extends ImageView {
    private final Image spikeBall;
    private final ImageView view;

    public SpikeBall() {
        spikeBall = new Image("images/spikeBall.png");
        view = new ImageView(spikeBall);
        view.setPreserveRatio(true);
        view.setFitWidth(50);
        view.setFitHeight(50);
    }

    public ImageView getSpikeBall() {
        return this.view;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }

}
