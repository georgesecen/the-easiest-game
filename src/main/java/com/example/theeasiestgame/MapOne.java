package com.example.theeasiestgame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class MapOne extends Polygon {
    Polygon mapOne;
    public MapOne() {
        mapOne = new Polygon();
        mapOne.getPoints().addAll(new Double[]{
            0.0, 0.0,
            125.0, 0.0,
            125.0, -100.0,
            625.0, -100.0,
            625.0, 0.0,
            750.0, 0.0,
            750.0, 100.0,
            625.0, 100.0,
            625.0, 200.0,
            125.0, 200.0,
            125.0, 100.0,
            0.0, 100.0,
            0.0, 0.0
        });
        mapOne.setFill(Color.WHITE);
        mapOne.setStrokeWidth(4);
        mapOne.setStroke(Color.BLACK);
    }
    public Polygon getMapOne() {
        return mapOne;
    }
}
